package com.example.algorithm2025.leetcode01.test.stateMachine;

public class Main {
    public static void main(String[] args) {
        StateMachine sm = new StateMachine(State.INIT);

        // 添加转移规则
        sm.addTransition(new Transition(State.INIT, Event.CREATE, State.WAIT_PAY, null, () -> System.out.println("订单创建")));
        sm.addTransition(new Transition(State.WAIT_PAY, Event.PAY, State.PAID, null, () -> System.out.println("支付成功")));
        sm.addTransition(new Transition(State.PAID, Event.SHIP, State.SHIPPED, null, () -> System.out.println("发货")));
        sm.addTransition(new Transition(State.SHIPPED, Event.CONFIRM, State.FINISHED, null, () -> System.out.println("订单完成")));
        sm.addTransition(new Transition(State.WAIT_PAY, Event.CANCEL, State.CANCELED, null, () -> System.out.println("取消订单")));
        // PAID状态下取消订单需要条件（比如未发货才允许取消）
        sm.addTransition(new Transition(State.PAID, Event.CANCEL, State.CANCELED, v -> false, () -> System.out.println("已支付不能取消"))); // 条件不满足

        // 状态流转
        sm.handleEvent(Event.CREATE);   // 订单创建，状态转移到WAIT_PAY
        sm.handleEvent(Event.PAY);      // 支付成功，状态转移到PAID
        sm.handleEvent(Event.CANCEL);   // 已支付不能取消，条件不满足
        sm.handleEvent(Event.SHIP);     // 发货，状态转移到SHIPPED
        sm.handleEvent(Event.CONFIRM);  // 订单完成，状态转移到FINISHED
    }
}
