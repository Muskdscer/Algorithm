package com.example.algorithm.binaryTree;

public class SearchBST {
    //递归，普通二叉树
    public TreeNode searchBST1(TreeNode root, int val)
    {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST1(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST1(root.right, val);
    }

    // 递归，利用二叉搜索树特点，优化
    public TreeNode searchBST2(TreeNode root, int val)
    {
        if (root == null || root.val == val) {
            return null;
        }
        if (root.val > val) {
            return searchBST2(root.left, val);
        }
        return searchBST2(root.right, val);
    }
}
