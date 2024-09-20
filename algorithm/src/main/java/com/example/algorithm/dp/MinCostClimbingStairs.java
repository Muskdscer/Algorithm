package com.example.algorithm.dp;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];

        //从下标为0或下标为1的台阶开始，因此支付费用为0
        dp[0] = 0;
        dp[1] = 0;

        //计算到达每一台阶的最小费用
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
