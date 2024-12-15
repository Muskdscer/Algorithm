package com.example.algorithm.kamaCoder.dp;

import java.util.Arrays;

public class LongestRepeatingSubarray {
    public static void main(String[] args) {
        int[] numsA = new int[]{1,2,3,2,1};
        int[] numsB = new int[]{3,2,1,4,7};
        int length = getLength(numsA, numsB);
    }

    private static int getLength(int[] numsA, int[] numsB) {
        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
        int[][] dp =  new int[numsA.length + 1][numsB.length + 1];
        Arrays.fill(dp, 0);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= numsA.length; i++) {
            for (int j = 1; j <= numsB.length; j++) {
                if (numsA[i - 1] == numsB[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
