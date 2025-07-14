package com.example.algorithm2025.leetcode01.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    private int res = 0;
    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        traversal(root, targetSum, 0L);
        return res;
    }

    private void traversal(TreeNode root, int targetSum, long sum) {
        if (root == null) return;
        sum += root.val;
        if (map.containsKey(sum - targetSum)) {
            res += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        traversal(root.left, targetSum, sum);
        traversal(root.right, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
    }
}
