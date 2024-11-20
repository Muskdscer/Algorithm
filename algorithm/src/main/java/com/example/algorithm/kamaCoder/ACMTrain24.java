package com.example.algorithm.kamaCoder;

import java.util.Scanner;
//最长公共子序列
public class ACMTrain24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] s = line.split(" ");
            String x = s[0];
            String y = s[1];
            int m = x.length();
            int n = y.length();
            //dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            int max = dp[m][n];
            System.out.println(max);
        }
    }
}
