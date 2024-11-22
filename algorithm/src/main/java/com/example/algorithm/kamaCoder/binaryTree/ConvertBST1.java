package com.example.algorithm.kamaCoder.binaryTree;

public class ConvertBST1 {
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

    static int num = 0;
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

        convertBST1(root);
    }

    private static void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }

        convertBST1(root.right);
        num += root.val;
        root.val = num;
        convertBST1(root.left);
    }
}
