package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class IncrementSubsequences {
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 7};
        getResultSet(nums, 0);
    }

    private static void getResultSet(int[] nums, int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast() || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            getResultSet(nums, i + 1);
            path.removeLast();
        }
    }
}
