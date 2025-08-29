package com.example.algorithm2025.leetcode01.event;

/**
 * 事件监听者。注意：此时已经没有线程上下文，如果需要请修改构造函数，显示复制上下文信息
 */
public class EventSubscriber implements Runnable{
    /**
     * 业务监听器
     **/
    private BizEventListener bizEventListener;

    /**
     * 业务事件
     */
    private BizEvent bizEvent;

    /**
     * @param bizEventListener 事件监听者
     * @param bizEvent         事件
     */
    public EventSubscriber(BizEventListener bizEventListener, BizEvent bizEvent) {
        super();
        this.bizEventListener = bizEventListener;
        this.bizEvent = bizEvent;
    }
    @Override
    public void run() {
        bizEventListener.onEvent(bizEvent);
    }
}
