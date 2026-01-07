package com.example.algorithm2025.leetcode01.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum1CanRepeat {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0 ,target, 0);
        return res;
    }
    private void combinationSumHelper(int[] candidates, int sum, int target, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            combinationSumHelper(candidates, sum, target, index);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
