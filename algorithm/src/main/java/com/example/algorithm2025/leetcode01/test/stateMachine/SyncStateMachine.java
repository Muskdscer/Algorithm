package com.example.algorithm2025.leetcode01.test.stateMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
//如果某个状态需要子流程，可以在主状态机的某个状态内，持有一个子状态机对象，在主状态机的事件处理方法中调度子状态机。例如订单的“售后”流程可以单独建一个状态机
public class SyncStateMachine {
    private State current;
    private List<SyncTransition> transitions = new ArrayList<>();
    private List<StateChangeListener> listeners = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public SyncStateMachine(State initial) {
        this.current = initial;
    }

    public void addTransition(SyncTransition t) {
        transitions.add(t);
    }

    public void addListener(StateChangeListener l) {
        listeners.add(l);
    }

    public State getCurrent() {
        return current;
    }

    public void handleEvent(EventData eventData) {
        lock.lock();
        try {
            for (SyncTransition transition : transitions) {
                if (transition.from == current && transition.event == eventData.event && transition.condition.test(eventData)) {
                    State old = current;
                    if (transition.action != null) {
                        transition.action.accept(eventData);
                    }
                    current = transition.to;
                    for (StateChangeListener listener : listeners) {
                        listener.onStateChanged(old, current, eventData);
                    }
                    System.out.println("状态转移到：" + current);
                    return;
                }
            }
            System.out.println("无效事件或条件不满足，当前状态：" + current);
        } finally {
            lock.unlock();
        }
    }
}
