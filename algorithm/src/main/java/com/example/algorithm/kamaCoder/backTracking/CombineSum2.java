package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombineSum2 {
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        getResultList(nums, target, res, path, used, 0);
    }

    private static void getResultList(int[] nums, int target, List<List<Integer>> res, LinkedList<Integer> path, boolean[] used, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }

            //出现重复节点，同层第一个节点已经被访问过 所以直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += nums[i];
            path.add(nums[i]);
            //每个节点只能选择一次，从下一位开始
            getResultList(nums, target, res, path, used, i + 1);
            used[i] = false;
            sum -= nums[i];
            path.removeLast();
        }
    }
}
