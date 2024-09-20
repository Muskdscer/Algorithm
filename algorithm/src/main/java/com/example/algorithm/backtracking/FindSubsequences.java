package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }
    private void backTracking(int[] nums, int startIndex)
    {

    }

}
