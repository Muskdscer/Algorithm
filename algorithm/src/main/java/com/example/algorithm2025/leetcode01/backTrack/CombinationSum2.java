package com.example.algorithm2025.leetcode01.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//组合总和II 每个数只能用一次
public class CombinationSum2 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ans;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }

            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            //每个数只能选一次
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
