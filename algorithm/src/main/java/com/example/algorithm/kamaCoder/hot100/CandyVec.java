package com.example.algorithm.kamaCoder.hot100;

import java.util.Arrays;

public class CandyVec {
    public static void main(String[] args) {
        int[] scores = new int[]{1,0,2};
        int[] candies = getCandyNum(scores);
    }

    private static int[] getCandyNum(int[] scores) {
        int[] res = new int[scores.length];
        Arrays.fill(res, 1);
        //处理某一个分数和 看是不是比左边大  比左边大的话 +1
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                res[i]++;
            }
        }

        //处理某一分数和右边比较 看是不是比右边大  比右边大+1
        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                res[i]++;
            }
        }
        return res;
    }
}
