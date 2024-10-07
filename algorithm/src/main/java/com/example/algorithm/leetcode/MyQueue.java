package com.example.algorithm.leetcode;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }
    public int peek(){
        dumpstackIn();
        return stackOut.peek();
    }
    public boolean empty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    //如果stackOut中为空 那么将stackIn中元素全部放到stackOUt中
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
