package com.example.algorithm.designPattern.responsibility;

/**
 * 抽象处理者（Handler）：定义处理请求的接口，并包含对下一个处理者的引用
 */
public abstract class AbstractHandler {
    /**
     * 下一关用当前抽象类来接收
     */
    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract int handler();
}
