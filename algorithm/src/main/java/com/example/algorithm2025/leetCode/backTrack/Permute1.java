package com.example.algorithm2025.leetCode.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute1 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        used = new boolean[nums.length];
        int k = nums.length;
        permuteHelper(nums);
        return res;
    }

    private void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }

    }
}
