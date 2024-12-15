package com.example.algorithm.kamaCoder.dp;

import java.util.Arrays;

public class LongestIncrSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int length = getMaxLength(nums);
    }

    private static int getMaxLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
