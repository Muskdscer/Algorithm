package com.example.algorithm2025.leetcode01.test.stateMachine;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class SyncTransition {
    State from;
    Event event;
    State to;
    Predicate<EventData> condition; // 支持参数
    Consumer<EventData> action;     // 支持参数

    public SyncTransition(State from, Event event, State to, Predicate<EventData> condition, Consumer<EventData> action) {
        this.from = from;
        this.event = event;
        this.to = to;
        this.condition = condition != null ? condition : e -> true;
        this.action = action;
    }
}
