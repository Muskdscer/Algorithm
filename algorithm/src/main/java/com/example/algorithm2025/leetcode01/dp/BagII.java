package com.example.algorithm2025.leetcode01.dp;

import java.util.Scanner;

public class BagII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m =  sc.nextInt();//材料数量
        int n = sc.nextInt();//行李空间大小
        int[] costs = new int[m];//每种材料占用空间
        int[] values = new int[m];//每种材料价值

        //输入每种材料价值
        for (int i = 0; i < m; i++) {
            values[i] = sc.nextInt();
        }
        //输入每种材料占用
        for (int i = 0; i < m; i++) {
            costs[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        //外层循环材料
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= costs[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - costs[i]] + values[i]);
            }
        }
    }
}
