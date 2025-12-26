package com.example.algorithm2025.leetcode01.test.aop;

import org.springframework.stereotype.Service;

/**
 * 入库服务实现类
 */
@Service
public class InboundServiceImpl {
    /**
     * 入库确认（标注审计注解）
     */
    @Override
    @WmsAudit(operationType = "入库确认", operationDesc = "物料检验合格后放行入库")
    public Boolean confirmInbound(InboundConfirmDTO confirmDTO) {
        // 业务逻辑：更新物料状态为已入库、扣减待检库存、同步ERP库存等
        // ...
        return true;
    }
}
