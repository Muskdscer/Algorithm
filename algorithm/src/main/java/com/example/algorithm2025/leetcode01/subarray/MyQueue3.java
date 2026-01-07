package com.example.algorithm2025.leetcode01.subarray;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue3 {
    Deque<Integer> deque = new LinkedList<>();
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.peek()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }
}
