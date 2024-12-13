package com.example.algorithm.kamaCoder.dp;

import java.lang.*;
import java.util.*;
import java.io.*;

public class ClimbStairsUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        while (sc.hasNextInt()) {
            // 从键盘输入参数，中间用空格隔开
            n = sc.nextInt();
            m = sc.nextInt();
            //求排列问题
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i - j >= 0) {
                        dp[i] += dp[i - j];
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}
