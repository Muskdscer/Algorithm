package com.example.algorithm2025.leetCode.greedy;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int miniPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < miniPrice) {
                miniPrice = prices[i];
            } else if (prices[i] - miniPrice > maxProfit) {
                maxProfit = prices[i] - miniPrice;
            }
        }
        return maxProfit;
    }
}
