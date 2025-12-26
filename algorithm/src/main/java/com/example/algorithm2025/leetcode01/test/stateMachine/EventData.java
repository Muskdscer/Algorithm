package com.example.algorithm2025.leetcode01.test.stateMachine;

import java.util.Map;

//事件对象
public class EventData {
    public final Event event;
    public final Map<String, Object> params; // 可扩展参数

    public EventData(Event event, Map<String, Object> params) {
        this.event = event;
        this.params = params;
    }
}
