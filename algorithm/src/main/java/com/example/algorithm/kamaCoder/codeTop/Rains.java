package com.example.algorithm.kamaCoder.codeTop;

import java.util.Stack;

public class Rains {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = getMaxRains(height);
    }

    private static int getMaxRains(int[] height) {
        Stack<Integer> stack =  new Stack<>();
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            int stackTop = stack.peek();
            if (height[stack.peek()] > height[i]) {
                stack.push(i);
            } else if (height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stackTop] < height[i]) {
                    int mid = height[stack.peek()];
                    if (!stack.isEmpty()) {
                        stack.pop();
                        int h = Math.min(height[i], height[stack.peek()]) - mid;
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
