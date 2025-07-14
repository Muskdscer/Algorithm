package com.example.algorithm2025.leetcode01.binaryTree;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        int priceNewpath = root.val + left + right;
        max = Math.max(priceNewpath, max);
        return Math.max(left, right) + root.val;
    }
}
