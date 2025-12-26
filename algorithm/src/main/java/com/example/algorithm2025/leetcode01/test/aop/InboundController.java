package com.example.algorithm2025.leetcode01.test.aop;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 入库管理接口（示例）
 */
@RestController
public class InboundController {
    private final InboundService inboundService;

    public InboundController(InboundService inboundService) {
        this.inboundService = inboundService;
    }

    /**
     * 物料入库确认（核心操作，需审计）
     */
    @PostMapping("/inbound/confirm")
    public Boolean confirmInbound(
            @RequestHeader("operatorId") String operatorId,
            @RequestHeader("operatorName") String operatorName,
            @RequestHeader("operationIp") String operationIp,
            @RequestBody InboundConfirmDTO confirmDTO) {

        // 1. 设置操作上下文（核心：传递审计所需的全局信息）
        WmsContextHolder.WmsOperateContext context = new WmsContextHolder.WmsOperateContext();
        context.setOperatorId(operatorId);
        context.setOperatorName(operatorName);
        context.setOperationIp(operationIp);
        context.setRelatedOrderNo(confirmDTO.getArrivalOrderNo()); // 到货单号
        context.setMaterialBatchNo(confirmDTO.getMaterialBatchNo()); // 物料批次号
        WmsContextHolder.setContext(context);

        // 2. 执行入库确认业务
        return inboundService.confirmInbound(confirmDTO);
    }
}
