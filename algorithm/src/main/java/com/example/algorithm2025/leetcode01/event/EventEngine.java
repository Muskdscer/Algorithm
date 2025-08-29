package com.example.algorithm2025.leetcode01.event;

/**
 * 事件引擎
 */
public interface EventEngine {
    /**
     * 发送事件
     *
     * @param event 事件
     */
    void publishEvent(BizEvent event);
}
