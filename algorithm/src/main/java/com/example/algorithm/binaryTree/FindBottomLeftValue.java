package com.example.algorithm.binaryTree;

public class FindBottomLeftValue {
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep)
    {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) {
            findLeftValue(root.left, deep + 1);
        }
        if (root.right != null) {
            findLeftValue(root.right, deep + 1);
        }
    }
}
