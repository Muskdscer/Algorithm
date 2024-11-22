package com.example.algorithm.kamaCoder.binaryTree;

public class IsValidBST {
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

    static TreeNode max;
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

        boolean flag = isBST(root);
    }

    private static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //左
        boolean left = isBST(root.left);
        if (!left) {
            return false;
        }

        //中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;

        //右
        boolean right = isBST(root.right);
        return right;
    }
}
