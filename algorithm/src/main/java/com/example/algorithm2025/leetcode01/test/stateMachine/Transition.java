package com.example.algorithm2025.leetcode01.test.stateMachine;

import java.util.function.Predicate;

//转移结构体
public class Transition {
    State from;
    Event event;
    State to;
    Predicate<Void> condition; // 转移条件，可为null表示无条件
    Runnable action;  //转移动作，可为null表示无动作

    public Transition(State from, Event event, State to, Predicate<Void> condition, Runnable action) {
        this.from = from;
        this.event = event;
        this.to = to;
        this.condition = condition != null ? condition : v -> true;
        this.action = action;
    }
}
