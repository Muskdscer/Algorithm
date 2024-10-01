package com.example.algorithm.greedy;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        //从左至右
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
        }
        //从右至左
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i],candyVec[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int i : candyVec) {
            ans += i;
        }
        return ans;
    }
}
