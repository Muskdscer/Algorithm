package com.example.algorithm.kamaCoder.dp;

import java.util.Arrays;

public class LinesNotIntersect {
    public static void main(String[] args) {
        int[] numsA = new int[]{1,4,2};
        int[] numsB = new int[]{1,2,4};
        int length = getLength(numsA, numsB);
    }

    private static int getLength(int[] numsA, int[] numsB) {
        int[][] dp = new int[numsA.length + 1][numsB.length + 1];
        Arrays.fill(dp, 0);

        for (int i = 1; i < numsA.length; i++) {
            for (int j = 1; j < numsB.length; j++) {
                if (numsA[i - 1] == numsB[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[numsA.length][numsB.length];
    }
}
