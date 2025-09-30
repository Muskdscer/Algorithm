package com.example.algorithm2025.leetcode01.twopointer;

import java.util.HashMap;
import java.util.Map;

public class DDtest {
    int sum;
    public int getNearSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        int absSum =Integer.MAX_VALUE;
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length - 3; i++) {
            left = i + 1;
            int tempNum = nums[i] + nums[left] + nums[right];
            sum += tempNum;
            while (left < right) {
                if (sum < target) {
                    left++;
                    absSum = Math.min(Math.abs(sum - target),absSum);
                    res.put(absSum, sum);
                }
                if (sum > target) {
                    right--;
                    absSum = Math.min(Math.abs(sum - target),absSum);
                }
                if (sum == target) {
                    return sum;
                }
            }
        }
        return res.get(absSum);
    }
}
