package com.example.algorithm.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * size; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % size]) {
                res[stack.peek()] = nums[i % size];
                stack.pop();
            }
            stack.push(i % size);
        }
        return res;
    }
}
