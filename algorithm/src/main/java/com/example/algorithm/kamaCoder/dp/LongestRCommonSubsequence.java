package com.example.algorithm.kamaCoder.dp;

import java.util.Arrays;

public class LongestRCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int length = getCommonSequence(text1, text2);
    }

    private static int getCommonSequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
