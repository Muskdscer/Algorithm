package com.example.algorithm.kamaCoder.hash;

import java.lang.*;
import java.util.*;
import java.io.*;

public class ThreeSum {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        list = findThreeSum(nums);
        System.out.println("找到组合数为：" + list.size());
    }

    private static List<List<Integer>> findThreeSum(int[] nums) {
        if (nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            //i-1已经处理完了 到i了，如果和前面一个相同直接跳过  去重
            if (i > 0 && nums[i] == nums[i - 1]) {
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
                    list.add(Arrays.asList(i, left, right));
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}
