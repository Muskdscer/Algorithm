package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backtracking(res,path,candidates,target,sum+candidates[i],i);
            path.remove(path.size()-1);//回溯 移除path最后一个元素
        }
    }
}
