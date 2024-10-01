package com.example.algorithm.greedy;

public class WiggleMaxLength1 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i-1];
            if ((preDiff > 0 && curDiff <= 0) || (preDiff < 0 && curDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
