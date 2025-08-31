package com.example.algorithm2025.leetcode01.subarray;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue1 {
    Deque<Integer> deque = new LinkedList<>();
    //val和队列里最大值一样 可以poll掉 换最新的val
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }
}
