package com.example.algorithm2025.leetcode01.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute1 {
    List<List<Integer>> result = new ArrayList<>();//收集结果
    LinkedList<Integer> path = new LinkedList<>();//存放符合条件的结果

    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    public void permuteHelper(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
