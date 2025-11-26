package com.example.algorithm2025.leetcode01.twopointer;

public class ATest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-3,3,-1,5,-4,4};
        int result = maxSum(nums);
        System.out.println("最大连续子数组和" + result);
    }

    public static int maxSum(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > 0) {
                max = Math.max(max, sum);
            } else {
                sum = 0;
            }
        }
        return max;
    }
}
