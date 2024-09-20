package com.example.algorithm.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class SelfQueue {
    Deque<Integer> deque = new LinkedList<>();
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while(!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }

}
