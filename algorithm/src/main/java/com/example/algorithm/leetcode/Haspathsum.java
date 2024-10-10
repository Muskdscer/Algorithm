package com.example.algorithm.leetcode;

public class Haspathsum {
    public boolean haspathsum(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        targetsum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0;
        }
        if (root.left != null) {
            boolean left = haspathsum(root.left, targetsum);
            if (left) {      // 已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = haspathsum(root.right, targetsum);
            if (right) {     // 已经找到
                return true;
            }
        }
        return false;
    }
}
