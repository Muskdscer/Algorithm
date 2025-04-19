package com.example.algorithm2025.leetCode.dp;

public class NumSquares {
    //先遍历背包 再遍历物品
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //当和为0时，组合个数为0
        dp[0] = 0;
        //遍历背包
        for (int i = 1; i <= n; i++) {
            //遍历物品
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
