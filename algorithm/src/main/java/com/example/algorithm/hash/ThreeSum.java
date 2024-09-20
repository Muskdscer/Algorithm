package com.example.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //排序之后如果第一个元素已经大于0， 无论如何都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) return result;

            if (i > 0 && nums[i] == nums[i - 1]) {//去重
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
