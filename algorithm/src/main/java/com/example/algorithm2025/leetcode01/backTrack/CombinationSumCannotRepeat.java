package com.example.algorithm2025.leetcode01.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumCannotRepeat {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, 0, target, 0);
        return ans;
    }

    private void combinationSum2Helper(int[] candidates, int sum, int target, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > 0 && candidates[i] == candidates[i -1] && !used[i -1]) {
                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            combinationSum2Helper(candidates, sum, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
