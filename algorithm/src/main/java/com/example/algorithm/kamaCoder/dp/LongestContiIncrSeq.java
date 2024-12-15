package com.example.algorithm.kamaCoder.dp;

import java.util.Arrays;

public class LongestContiIncrSeq {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        int length = getMaxContiLength(nums);
    }

    private static int getMaxContiLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
