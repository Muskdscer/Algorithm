package com.example.algorithm2025.leetCode.subarray;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum1 {

    private int res = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return res;
        }
        map.put(0, 1);
        findNum(nums, k, 0);
        return res;
    }

    private void findNum(int[] nums, int k, int sum) {
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }
}
