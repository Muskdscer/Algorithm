package com.example.algorithm2025.leetCode.subarray;

import java.util.HashMap;

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int result = subarraySum(nums, k);
        System.out.println("和为k的子数组个数为: " + k);
    }

    private static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
