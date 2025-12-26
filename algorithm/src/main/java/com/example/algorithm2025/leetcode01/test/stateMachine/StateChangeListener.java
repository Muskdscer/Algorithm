package com.example.algorithm2025.leetcode01.test.stateMachine;

//状态更新监听器  状态变更监听器可以让外部系统感知状态变化，便于扩展
public interface StateChangeListener {
    void onStateChanged(State from, State to, EventData eventData);
}
