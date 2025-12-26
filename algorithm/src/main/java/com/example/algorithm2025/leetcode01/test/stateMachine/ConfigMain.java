package com.example.algorithm2025.leetcode01.test.stateMachine;

import java.util.List;

public class ConfigMain {
    public static void main(String[] args) throws Exception {
        List<ConfigTransition> configs = ConfigurableStateMachine.loadConfig("test.json");
        ConfigurableStateMachine sm = new ConfigurableStateMachine(State.WAIT_PAY, configs);

        sm.handleEvent(Event.PAY);       // 状态转移到：PAID
        sm.handleEvent(Event.SHIP);      // 状态转移到：SHIPPED
        sm.handleEvent(Event.CONFIRM);   // 状态转移到：FINISHED
    }
}
