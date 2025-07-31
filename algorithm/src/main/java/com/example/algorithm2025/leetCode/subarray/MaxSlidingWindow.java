package com.example.algorithm2025.leetCode.subarray;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(nums, 3);
        for (int i : result) {
            System.out.println("滑动窗口最大值为： " + i);
        }
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 300l, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));
//        System.out.println("活跃线程数： " + threadPoolExecutor.getActiveCount() + "队列大小： " + threadPoolExecutor.getQueue().size());

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        int num = 0;
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        result[num] = myQueue.peek();
        num++;
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            result[num] = myQueue.peek();
            num++;
        }
        return result;
    }
}
