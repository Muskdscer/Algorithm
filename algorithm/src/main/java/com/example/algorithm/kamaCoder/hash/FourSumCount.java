package com.example.algorithm.kamaCoder.hash;

import java.lang.*;
import java.util.*;
import java.io.*;

public class FourSumCount {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        res = getFourSumCount(nums);
        System.out.println("共有" + res.size() + "种组合");
    }

    private static List<List<Integer>> getFourSumCount(int[] nums) {
        Arrays.sort(nums);  // 排序数组

        if (nums[0] > 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0){
                        left++;
                    } else {
                        res.add(Arrays.asList(i, j, left, right));
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
        }
        return res;
    }
}
