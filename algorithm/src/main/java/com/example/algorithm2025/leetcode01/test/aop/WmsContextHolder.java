package com.example.algorithm2025.leetcode01.test.aop;

import lombok.Data;

/**
 * WMS操作上下文（线程级）
 * 通过 ThreadLocal 存储当前操作的上下文信息（用户、IP、单据号等）：
 */
public class WmsContextHolder {
    // 线程本地存储
    private static final ThreadLocal<WmsOperateContext> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置操作上下文
     * 通过 ThreadLocal 存储当前操作的上下文信息（用户、IP、单据号等）：
     */
    public static void setContext(WmsOperateContext context) {
        CONTEXT_HOLDER.set(context);
    }

    /**
     * 获取操作上下文
     */
    public static WmsOperateContext getContext() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除上下文（防止内存泄漏）
     */
    public static void clearContext() {
        CONTEXT_HOLDER.remove();
    }

    /**
     * 操作上下文实体
     */
    @Data
    public static class WmsOperateContext {
        // 操作人ID
        private String operatorId;
        // 操作人姓名
        private String operatorName;
        // 操作IP
        private String operationIp;
        // 关联单据号（可选）
        private String relatedOrderNo;
        // 物料批次号（可选）
        private String materialBatchNo;
    }
}
