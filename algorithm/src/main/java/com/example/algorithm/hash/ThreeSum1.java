package com.example.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum1 {
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            //三元数组a去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                //三元数组对b去重
                if (j > i + 2 && nums[j] == nums[j-1] && nums[j-1] == nums[j-2]) {
                    continue;
                }

                int c = 0-nums[i]-nums[j];
                if (set.contains(c)) {
                    result.add(Arrays.asList(nums[i], nums[j], c));
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return result;
    }
}
