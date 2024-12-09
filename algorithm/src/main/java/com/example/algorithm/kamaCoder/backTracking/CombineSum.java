package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombineSum {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        Arrays.sort(nums);
        combineSum22(nums, target);
    }

    private static void combineSum22(int[] nums, int target) {
        backTracking11(nums, target, 0, 0);
    }

    private static void backTracking11(int[] nums, int target, int start, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            path.add(nums[i]);
            backTracking11(nums, target, i, sum);
            sum -= nums[i];
            path.removeLast();
        }
    }
}
