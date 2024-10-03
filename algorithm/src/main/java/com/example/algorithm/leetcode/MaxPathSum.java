package com.example.algorithm.leetcode;

public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(maxGain(node.left),0);
        int right = Math.max(maxGain(node.right),0);

        int priceNewPath = node.val + left + right;

        //更新
        maxSum = Math.max(maxSum, priceNewPath);

        //返回节点最大贡献值
        return node.val + Math.max(left,right);
    }
}
