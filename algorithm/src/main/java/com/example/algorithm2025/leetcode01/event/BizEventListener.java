package com.example.algorithm2025.leetcode01.event;

import java.util.EventListener;

/**
 * 业务事件监听器
 */
public interface BizEventListener extends EventListener {

    /**
     * 是否执行事件
     *
     * @param event 事件
     * @return
     */
    public boolean decide(BizEvent event);

    /**
     * 执行事件
     *
     * @param event 事件
     */
    public void onEvent(BizEvent event);
}
