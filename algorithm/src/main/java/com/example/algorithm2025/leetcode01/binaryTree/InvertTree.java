package com.example.algorithm2025.leetcode01.binaryTree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        swap(root, left, right);
        return root;
    }

    private void swap(TreeNode root, TreeNode left, TreeNode right) {
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
    }
}
