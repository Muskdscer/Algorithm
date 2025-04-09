package com.example.algorithm2025.leetCode.binaryTree;

public class KthSmallest {
    int res, k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (k == 0) {
            return;
        }
        k--;
        if (k == 0) {
            res = root.val;
        }
        traversal(root.right);
    }
}
