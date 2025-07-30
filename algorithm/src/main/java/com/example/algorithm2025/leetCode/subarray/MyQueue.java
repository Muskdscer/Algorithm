package com.example.algorithm2025.leetCode.subarray;

import java.util.Deque;
import java.util.LinkedList;

//单调队列
public class MyQueue {
    Deque<Integer> que = new LinkedList<>();

    void poll(int val) {
        while (!que.isEmpty() && val == que.peek()) {
            que.poll();
        }
    }

    void add(int val) {
        while (!que.isEmpty() && val > que.getLast()) {
            que.removeLast();
        }
        que.add(val);
    }

    int peek() {
        return que.peek();
    }
}
