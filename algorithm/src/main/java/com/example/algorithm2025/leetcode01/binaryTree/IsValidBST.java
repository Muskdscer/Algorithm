package com.example.algorithm2025.leetcode01.binaryTree;

public class IsValidBST {
    //递归
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        //中
        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;
        //右
        boolean right = isValidBST(root.right);
        return right;
    }
}
