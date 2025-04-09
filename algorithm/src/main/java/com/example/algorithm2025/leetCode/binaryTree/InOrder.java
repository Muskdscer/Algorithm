package com.example.algorithm2025.leetCode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public List<Integer> result = new ArrayList<>();

    public List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        inorderTraversal(root);
        return result;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
}
