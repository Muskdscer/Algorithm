package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum2 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        used = new boolean[candidates.length];
        //加标志数组，用来辅助判断同层结点是否已经遍历
        Arrays.fill(used,false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return ans;
    }

    private void backtracking(int[] candidates, int target, int startIndex)
    {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            //每个节点仅能选择一次 从下一位开始
            backtracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
