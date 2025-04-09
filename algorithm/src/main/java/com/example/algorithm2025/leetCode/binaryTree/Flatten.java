package com.example.algorithm2025.leetCode.binaryTree;

public class Flatten {
    private TreeNode pre = null;
     public void flatten(TreeNode root) {
         if (root == null) {
             return;
         }
         flatten(root.left);
         flatten(root.right);
         root.right = pre;
         root.left = null;
         pre = root;
     }
}
