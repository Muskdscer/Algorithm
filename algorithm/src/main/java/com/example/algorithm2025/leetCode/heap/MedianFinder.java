package com.example.algorithm2025.leetCode.heap;

import java.util.PriorityQueue;

public class MedianFinder {
    private final PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);//最大堆
    private final PriorityQueue<Integer> right = new PriorityQueue<>(); //最小堆
    public MedianFinder() {
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }
        return (left.peek() + right.peek()) / 2.0;
    }
}
