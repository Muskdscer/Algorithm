package com.example.algorithm.designPattern.observer;

/**
 * 观者者基类
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
