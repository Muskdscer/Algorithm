package com.example.algorithm.dp;

import java.util.concurrent.ConcurrentHashMap;

public class TestCompletePack {
    public static  void testCompletePack(){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagweight = 4;
        int[] dp = new int[bagweight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagweight; j++) {
                dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
            }
        }
    }
}
