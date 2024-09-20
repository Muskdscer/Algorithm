package com.example.algorithm.stackAndQueue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果的元素
        int[] res = new int[len];
        int num = 0;
        SelfQueue myQueue = new SelfQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }

}
