package com.example.algorithm2025.leetCode.dp;

public class LongestValidParentheses {
    public int longestValidParentheses(String str) {
        // f[j]表示子串最右元素为下标j的最长长度（很多动规都是枚举当前元素为最右元素）
        char[] s = str.toCharArray();
        int n = s.length;
        int[] f = new int[n];
        int ans = 0;
        for (int i = 1; i < n; ++ i) {
            if (s[i] == ')') {
                if (i - f[i - 1] - 1 >= 0 && s[i - f[i - 1] - 1] == '(') {
                    f[i] = f[i - 1] + 2;
                }
                if(i - f[i] >= 0) f[i] += f[i - f[i]];
            }

            ans = Math.max(ans, f[i]);
        }

        return ans;
    }
}
