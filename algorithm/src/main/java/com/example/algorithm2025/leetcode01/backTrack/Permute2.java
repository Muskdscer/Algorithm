package com.example.algorithm2025.leetcode01.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute2 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        permuteHelp(nums);
        return result;
    }

    private void permuteHelp(int[] nums) {
        if (path.size() == nums.length) {
            result.add(path);
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            permuteHelp(nums);
            used[i] = false;
            path.removeLast();
        }
    }


}
