package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSet2 {
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        getResultList(nums, 0, used);
    }

    private static void getResultList(int[] nums, int start, boolean[] used) {
        res.add(new ArrayList<>(path));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            getResultList(nums, i + 1, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
