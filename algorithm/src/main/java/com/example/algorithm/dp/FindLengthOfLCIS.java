package com.example.algorithm.dp;

public class FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i : dp) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = dp[i + 1] > res ? dp[i + 1] : res;
        }
        return res;
    }
}
