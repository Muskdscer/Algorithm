package com.example.algorithm2025.leetCode.binaryTree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root,root.left, root.right);
        return root;
    }

    private void swap(TreeNode root,TreeNode left, TreeNode right) {
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
    }
}
