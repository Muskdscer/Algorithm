package com.example.algorithm2025.leetcode01.binaryTree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }
    }
}
