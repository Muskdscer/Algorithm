package com.example.algorithm.dp;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        while (sc.hasNext()) {
            m = sc.nextInt();
            n = sc.nextInt();
            //求排列问题 先遍历背包 再遍历物品
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= m; i++) {
                    if (j - 1 >= 0) {
                        dp[j] += dp[j - i];
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}
