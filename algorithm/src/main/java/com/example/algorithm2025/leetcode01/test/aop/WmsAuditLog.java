package com.example.algorithm2025.leetcode01.test.aop;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * WMS审计日志表（符合GMP合规要求，不可修改）
 */
@Data
//@TableName("wms_audit_log")
public class WmsAuditLog {
    /**
     * 主键ID
     */
    //@TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 操作人ID
     */
    private String operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 操作类型（入库确认、出库放行等）
     */
    private String operationType;

    /**
     * 操作描述
     */
    private String operationDesc;

    /**
     * 关联单据号（到货单/领料单/销售出库单ID）
     */
    private String relatedOrderNo;

    /**
     * 物料批次号（制药核心字段）
     */
    private String materialBatchNo;

    /**
     * 请求参数（JSON格式）
     */
    private String requestParam;

    /**
     * 返回结果（JSON格式）
     */
    private String responseResult;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;

    /**
     * 操作IP
     */
    private String operationIp;

    /**
     * 操作结果（SUCCESS/FAIL）
     */
    private String operationResult;

    /**
     * 异常信息（失败时填充）
     */
    private String exceptionMsg;

    /**
     * 数据版本（防篡改）
     */
    private Integer version = 1;
}
