package com.example.algorithm.dp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagWeight = scanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
        }

        int[][] dp = new int[n][bagWeight + 1];
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        System.out.println(dp[n - 1][bagWeight]);
    }
}
