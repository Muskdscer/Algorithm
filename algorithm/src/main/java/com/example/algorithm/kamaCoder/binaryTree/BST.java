package com.example.algorithm.kamaCoder.binaryTree;

public class BST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeNode rootNew = searchBST(root, 2);
        System.out.println("新的根节点为： " + rootNew.val);
    }

    private static TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        if (root.val > target) {
            return searchBST(root.left, target);
        } else {
            return searchBST(root.right, target);
        }
    }
}
