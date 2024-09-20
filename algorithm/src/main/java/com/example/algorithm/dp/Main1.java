package com.example.algorithm.dp;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; ++i) {
            weight[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; ++j) {
            value[j] = scanner.nextInt();
        }

        int[][] dp = new int[n][bagweight + 1];
        for (int i = weight[0]; i <= bagweight; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagweight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
                }
            }
        }
}
