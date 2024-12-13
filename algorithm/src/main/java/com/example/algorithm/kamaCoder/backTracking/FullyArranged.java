package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FullyArranged {
    static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    static boolean[] used;
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        fullyArrange(nums);
    }

    private static void fullyArrange(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            fullyArrange(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
