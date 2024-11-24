package com.example.algorithm.kamaCoder.dp;

public class ClimbStairsLessCost {
    //dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]。
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int dp[] = new int[len + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
