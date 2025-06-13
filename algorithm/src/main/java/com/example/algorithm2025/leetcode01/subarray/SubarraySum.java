package com.example.algorithm2025.leetcode01.subarray;


import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 4, 3, 5, 7, 3, 10};
        int result = subarraySum(nums, 15);
        System.out.println("和为15的子数组个数为：" + result);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
