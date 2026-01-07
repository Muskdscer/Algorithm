package com.example.algorithm2025.leetcode01.subarray;

public class MaxSlidingWindow2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue3 myQueue = new MyQueue3();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num] = myQueue.peek();
        num++;
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num] = myQueue.peek();
            num++;
        }
        return res;
    }
}
