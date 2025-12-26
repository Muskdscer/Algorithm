package com.example.algorithm2025.leetcode01.test.aop;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;


/**
 * WMS审计日志切面
 * 统一拦截核心操作，生成合规审计日志
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class WmsAuditAspect {

    // 注入日志DAO/Service（实际项目中替换为你的持久化接口）
    private final WmsAuditLogService auditLogService;

    /**
     * 切点：拦截所有标注@WmsAudit的方法
     */
    @Pointcut("@annotation(com.example.algorithm2025.leetcode01.test.aop.WmsAudit)")
    public void auditPointcut() {
    }

    /**
     * 环绕通知：拦截方法执行，记录审计日志
     */
    @Around("auditPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 初始化审计日志对象
        WmsAuditLog auditLog = new WmsAuditLog();
        Object result = null;
        Exception exception = null;

        try {
            // 2. 获取注解信息
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            WmsAudit auditAnnotation = method.getAnnotation(WmsAudit.class);

            // 3. 填充基础审计信息
            auditLog.setOperationType(auditAnnotation.operationType());
            auditLog.setOperationDesc(auditAnnotation.operationDesc());
            auditLog.setOperationTime(LocalDateTime.now());

            // 4. 从上下文获取用户/单据/批次信息（核心：制药行业追溯）
            WmsContextHolder.WmsOperateContext operateContext = WmsContextHolder.getContext();
            if (operateContext != null) {
                auditLog.setOperatorId(operateContext.getOperatorId());
                auditLog.setOperatorName(operateContext.getOperatorName());
                auditLog.setOperationIp(operateContext.getOperationIp());
                auditLog.setRelatedOrderNo(operateContext.getRelatedOrderNo());
                auditLog.setMaterialBatchNo(operateContext.getMaterialBatchNo());
            }

            // 5. 记录请求参数（按需）
            if (auditAnnotation.recordParam()) {
                Object[] args = joinPoint.getArgs();
                auditLog.setRequestParam(JSONUtil.toJsonStr(args));
            }

            // 6. 执行原方法
            result = joinPoint.proceed();

            // 7. 记录返回结果（按需）
            if (auditAnnotation.recordResult()) {
                auditLog.setResponseResult(JSONUtil.toJsonStr(result));
            }
            auditLog.setOperationResult("SUCCESS");

            return result;
        } catch (Exception e) {
            exception = e;
            auditLog.setOperationResult("FAIL");
            auditLog.setExceptionMsg(e.getMessage());
            throw e; // 抛出异常，不影响业务流程
        } finally {
            // 8. 异步保存审计日志（不阻塞业务操作）
            saveAuditLog(auditLog);
            // 9. 清除上下文，防止内存泄漏
            WmsContextHolder.clearContext();
            log.info("WMS审计日志生成完成，操作类型：{}，单据号：{}，结果：{}",
                    auditLog.getOperationType(), auditLog.getRelatedOrderNo(), auditLog.getOperationResult());
        }
    }



    /**
     * 异步保存审计日志（核心：不阻塞业务，保证日志必存）
     */
    @Async("auditLogExecutor") // 自定义异步线程池
    public void saveAuditLog(WmsAuditLog auditLog) {
        try {
            // 保存到数据库（实际项目中可增加本地日志/区块链存证）
            auditLogService.save(auditLog);
            // 可选：写入本地审计日志文件（双存储，防止数据库故障丢失）
            log.info("【合规审计日志】{}", JSON.toJSONString(auditLog));
        } catch (Exception e) {
            // 日志保存失败触发告警（如短信/邮件）
            log.error("审计日志保存失败！日志内容：{}", JSON.toJSONString(auditLog), e);
            // 兜底：写入本地临时文件，后续定时任务重试
            // saveToLocalTempFile(auditLog);
        }
    }
}
