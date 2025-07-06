package com.example.algorithm2025.leetcode01.binaryTree;

//二叉树直径
public class DiameterOfBinaryTree {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        diameter = Math.max(diameter, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }
}
