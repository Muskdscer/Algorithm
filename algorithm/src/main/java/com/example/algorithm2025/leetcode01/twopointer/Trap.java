package com.example.algorithm2025.leetcode01.twopointer;

import java.util.Stack;

//接雨水
public class Trap {
    public int trap(int[] height) {
        int size = height.length;
        if (size <= 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Integer stackTop = stack.peek();
            if (height[i] < stackTop) {
                stack.push(i);
            } else if (height[i] == stackTop) {
                stack.pop();
                stack.push(i);
            } else {
                int heightAtIndex = height[i];
                while (!stack.isEmpty() && (heightAtIndex > height[stackTop])) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                    stack.push(i);
                }
            }
        }
        return sum;
    }
}
