package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSet {
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subset(nums, 0);
    }

    private static void subset(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            subset(nums, i + 1);
            path.removeLast();
        }
    }
}
