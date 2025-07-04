package com.example.algorithm2025.leetcode01.binaryTree;

public class IsValidBST {
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        //左
        boolean leftFlag = isValidBST(root.left);
        if (!leftFlag) {
            return false;
        }

        //中
        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;

        //右
        boolean rightFlag = isValidBST(root.right);
        return rightFlag;
    }
}
