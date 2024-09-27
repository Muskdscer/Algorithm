package com.example.algorithm.dp;

public class NumSquares {
    public int numSquares(int n)
    {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            //遍历背包
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
