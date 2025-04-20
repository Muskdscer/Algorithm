package com.example.algorithm2025.leetCode.dp;

public class LongestValidParentheses1 {
    public int longestValidParentheses(String str) {
        //设 dp 数组，其中第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度
        char[] chars = str.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] == ')') {
                if (i - dp[i - 1] - 1 >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2;
                }
                if (i - dp[i] >= 0) {
                    dp[i] += dp[i - dp[i]];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
