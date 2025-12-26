package com.example.algorithm2025.leetcode01.test.stateMachine;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {

    private State current;
    private List<Transition> transitions = new ArrayList<>();

    public StateMachine(State initial) {
        this.current = initial;
    }

    // 添加转移规则
    public void addTransition(Transition t) {
        transitions.add(t);
    }

    // 处理事件
    public void handleEvent(Event event) {
        for (Transition transition : transitions) {
            if (transition.from == current && transition.event == event && transition.condition.test(null)) {
                if (transition.action != null) {
                    transition.action.run();
                }
                current = transition.to;
                System.out.println("状态转移到：" + current);
                return;
            }
        }
        System.out.println("无效事件或条件不满足，当前状态：" + current);
    }

    public State getCurrent() {
        return current;
    }
}
