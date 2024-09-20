package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums)
    {
        subsetsHelper(nums, 0);
        return result;
    }
    private void subsetsHelper(int[] nums, int startIndex)
    {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }

}
