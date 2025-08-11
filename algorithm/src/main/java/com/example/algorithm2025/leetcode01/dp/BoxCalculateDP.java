package com.example.algorithm2025.leetcode01.dp;

public class BoxCalculateDP {
    public static int calculateBox(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) / 2 + i;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("6号箱子的货物个数： " + calculateBox(6));
    }

}
