package com.example.algorithm.kamaCoder.hot100;

import java.util.Scanner;

public class Bag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bagweight = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[n][bagweight + 1];
        for (int j = weight[0]; j <= bagweight; j++) {
            dp[0][j] = value[0];
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
        System.out.println(dp[n - 1][bagweight]);
    }
}
