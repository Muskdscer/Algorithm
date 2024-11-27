package com.example.algorithm.kamaCoder.codeTop;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        int[] res = nextGreaterElements(nums);
    }

    private static int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] res =  new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % size] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % size];
                stack.pop();
            }
            stack.push(i % size);
        }
        return res;
    }
}
