package com.example.algorithm2025.leetCode;

import java.util.Stack;

public class Trap {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(height);
        System.out.println("接雨水数量为: " + result);
    }

    private static int trap(int[] height) {
        int size = height.length;
        if (size <= 2) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int sum = 0;
        for (int i = 1; i < size; i++) {
            Integer stackTop  = stack.peek();
            if (height[i] < height[stackTop]) {
                stack.push(i);
            } else if (height[i] == height[stackTop]) {
                stack.pop();
                stack.push(i);
            } else {
                int heightAtIdx = height[i];
                while (!stack.isEmpty() && heightAtIdx > height[stackTop]) {
                    int mid = stack.pop();

                    if (!stack.isEmpty()) {
                        int left = stack.peek();

                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0) {sum += hold;}
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
