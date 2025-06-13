package com.example.algorithm2025.leetcode01.subarray;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(nums, 3);
        for (int i : result) {
            System.out.println("滑动窗口最大值为： " + i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyQueue myQueue = new MyQueue();
        //现将前k个元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num] = myQueue.peek();
        num++;
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面元素，
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            res[num] = myQueue.peek();
            num++;
        }
        return res;
    }
}
