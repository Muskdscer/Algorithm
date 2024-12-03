package com.example.algorithm.kamaCoder.hot100;

public class FindBottomLeftValue {

    int DEEP = -1;
    int deep = 0;
    int res;
    public int findBottomLeftValue(TreeNode root) {
        res = root.val;
        findVal(root, 0);
        return res;
    }

    private void findVal(TreeNode root, int deep) {
        if(root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (deep > DEEP) {
                res = root.val;
                DEEP = deep;
            }
        }

        if (root.left != null) {
            findVal(root.left, deep + 1);
        }

        if (root.right != null) {
            findVal(root.right, deep + 1);
        }
    }
}
