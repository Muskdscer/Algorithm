package com.example.algorithm2025.leetcode01.binaryTree;

public class IsSymmetric1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean outFlag = symmetric(left.left, right.right);
        boolean inFlag = symmetric(left.right, right.left);
        return outFlag && inFlag;
    }
}
