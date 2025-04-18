package com.example.algorithm2025.leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    //Deque三种用途
    //1.普通队列 一端进另一端出 Queue queue = new LinkedList()或Deque deque = new LinkedList()
    //addLast(e)[add(e)] offerLast(e)[offer(e)] removeLast()[remove()]  pollFirst()[poll()]  getFirst()[element()]  peekFirst()[peek()]
    //2.双端队列(两端都可进出) Deque deque = new LinkedList()
    //3.堆栈 Deque deque = new LinkedList()  push(e)   pop() peek()
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
