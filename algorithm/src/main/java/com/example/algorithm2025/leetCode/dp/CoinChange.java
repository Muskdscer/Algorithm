package com.example.algorithm2025.leetCode.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        //金额为0时需要的硬笔数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            //正序遍历 完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {
                //只有dp[j - coins[i]]不是初始最大值时，该位才有选择必要
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
