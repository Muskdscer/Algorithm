package com.example.algorithm2025.leetcode01.test.aop;


import java.lang.annotation.*;

/**
 * WMS核心操作审计注解
 * 标记需要生成审计日志的方法
 */
@Target({ElementType.METHOD}) // 仅作用于方法
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
@Documented
public @interface WmsAudit {
    /**
     * 操作类型（如：入库确认、出库放行、移库、盘点、供应商审核）
     */
    String operationType();

    /**
     * 操作描述（补充说明）
     */
    String operationDesc() default "";

    /**
     * 是否记录请求参数（默认是）
     */
    boolean recordParam() default true;

    /**
     * 是否记录返回值（默认是）
     */
    boolean recordResult() default true;
}
