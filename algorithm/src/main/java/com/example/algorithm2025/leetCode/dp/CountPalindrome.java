package com.example.algorithm2025.leetCode.dp;

public class CountPalindrome {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    result++;
                    dp[i][j] = true;
                } else if (dp[i + 1][j - 1]) {
                    result++;
                    dp[i][j] = true;
                }
            }
        }
        return result;
    }
}
