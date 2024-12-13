package com.example.algorithm.kamaCoder.dp;

public class ChangeExchange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        int res = change(amount, coins);
    }

    private static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
