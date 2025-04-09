package com.example.algorithm2025.leetCode.binaryTree;

public class IsSymmetric {
    public boolean isSymmetric (TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean flag = symmetric(left,right);
        return flag;
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
        //外侧
        boolean outside = symmetric(left.left, right.right);
        //内侧
        boolean inside = symmetric(left.right, right.left);
        return outside && inside;
    }

}
