package com.example.algorithm2025.leetcode01.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//组合总和
public class CombinationSum1 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, 0);
        return res;
    }

    private void combinationSumHelper(int[] candidates, int sum, int target, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            combinationSumHelper(candidates, sum, target, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
