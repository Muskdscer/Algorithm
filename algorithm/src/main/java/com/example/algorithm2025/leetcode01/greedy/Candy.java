package com.example.algorithm2025.leetcode01.greedy;

public class Candy {
    public int candy(int[] ratings) {
        int len =  ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        //从左向右
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
        }
        //从右向左
        for (int i = len - 2; i >= 0; i++) {
            if (candyVec[i] > candyVec[i + 1]) {
                //candyVec[i]保证比左边大
                //candyVec[i + 1] + 1保证比右边大
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int i : candyVec) {
            ans += i;
        }
        return ans;
    }
}
