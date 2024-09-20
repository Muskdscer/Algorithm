package com.example.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4)
    {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0));
            }
        }

        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                res += map.getOrDefault(0-sum, 0);
            }
        }
        return res;
    }
}
