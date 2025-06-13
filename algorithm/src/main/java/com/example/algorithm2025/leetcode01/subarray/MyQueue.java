package com.example.algorithm2025.leetcode01.subarray;

import java.util.Deque;
import java.util.LinkedList;

//单调队列
public class MyQueue {
    Deque<Integer> deque = new LinkedList<>();
    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }
    //添加元素时，如果要添加的元素大于入口处元素，就将入口处元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1,2要入队  比1大 1弹出 此时队列 3 2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }
    //队列顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}
