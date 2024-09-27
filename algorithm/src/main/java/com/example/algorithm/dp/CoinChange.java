package com.example.algorithm.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }

        //当金额为0时需要的硬币数为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            //正序遍历，完全背包每个硬币都可以选多个
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
