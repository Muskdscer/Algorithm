package com.example.algorithm2025.leetcode01.test.stateMachine;

import java.util.HashMap;
import java.util.Map;

public class SyncMain {
    public static void main(String[] args) {
        SyncStateMachine sm = new SyncStateMachine(State.INIT);
        //// 添加状态变更监听器
        sm.addListener((from, to, eventData) -> {
            System.out.println("监听器：状态从 " + from + " 变为 " + to + "，事件：" + eventData.event);
        });

        // 添加转移规则
        sm.addTransition(new SyncTransition(State.INIT, Event.CREATE, State.WAIT_PAY,
                null,
                e -> System.out.println("订单创建, 用户ID: " + e.params.get("userId"))));

        sm.addTransition(new SyncTransition(State.WAIT_PAY, Event.PAY, State.PAID,
                e -> ((Double) e.params.getOrDefault("amount", 0.0)) > 0,
                e -> System.out.println("支付成功, 金额: " + e.params.get("amount"))));

        sm.addTransition(new SyncTransition(State.PAID, Event.SHIP, State.SHIPPED,
                null,
                e -> System.out.println("发货, 物流单号: " + e.params.get("trackingNo"))));

        sm.addTransition(new SyncTransition(State.SHIPPED, Event.CONFIRM, State.FINISHED,
                null,
                e -> System.out.println("订单完成, 用户ID: " + e.params.get("userId"))));

        sm.addTransition(new SyncTransition(State.WAIT_PAY, Event.CANCEL, State.CANCELED,
                null,
                e -> System.out.println("取消订单")));

        // 流程演示
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "U123");
        sm.handleEvent(new EventData(Event.CREATE, params)); // 订单创建

        params.put("amount", 99.9);
        sm.handleEvent(new EventData(Event.PAY, params)); // 支付成功

        params.put("trackingNo", "T456");
        sm.handleEvent(new EventData(Event.SHIP, params)); // 发货

        sm.handleEvent(new EventData(Event.CONFIRM, params)); // 完成
    }
}
