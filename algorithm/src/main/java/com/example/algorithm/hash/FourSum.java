package com.example.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {//对nums[i]去重
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                //nums[i] + nums[j] > target 直接返回 剪枝操作
                if (nums[i]+nums[j] > 0 && nums[i] + nums[j] > target) {
                    return result;
                }

                if (j > i + 1 && nums[j] == nums[j - 1]) {//对nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //nums[i] + nums[j] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }

            }
        }
        return result;
    }
}
