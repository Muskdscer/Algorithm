package com.example.algorithm2025.leetcode01.event;

import java.util.EventObject;

/**
 * 业务事件
 */
public class BizEvent extends EventObject {
    /**
     * Topic
     */
    private final String topic;

    /**
     * 业务id
     */
    private final String bizId;

    /**
     * 数据
     */
    private final Object data;

    /**
     * @param topic 事件topic，用于区分事件类型
     * @param bizId 业务ID，标识这一次的调用
     * @param data  事件传输对象
     */
    public BizEvent(String topic, String bizId, Object data) {
        super(data);
        this.topic = topic;
        this.bizId = bizId;
        this.data = data;
    }

    /**
     * Getter method for property <tt>topic</tt>.
     *
     * @return property value of topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public Object getData() {
        return data;
    }
}
