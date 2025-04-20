package com.example.algorithm2025.leetCode.dp;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        //dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
