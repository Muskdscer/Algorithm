package com.example.algorithm2025.leetcode01.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);//排序
        List<List<Integer>> result = new ArrayList<>();//结果集
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //剪枝
                if (nums[i] + nums[j] >= 0 && nums[i] + nums[j] > target) {
                    break;
                }
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
