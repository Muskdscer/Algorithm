package com.example.algorithm.kamaCoder.binaryTree;

public class GetMindepth {
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

    //最小深度
    static int depth;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(10);
        TreeNode node10 = new TreeNode(11);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;
        node4.left = node9;
        node4.right = node10;

        depth = getMinDepth(root);
        System.out.println("二叉树最大深度： " + depth);
    }

    private static int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return getMinDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return getMinDepth(root.left) + 1;
        }

        //左右都不为null
        int leftDepth = getMinDepth(root.left);
        int rightDepth = getMinDepth(root.right);

        return Math.min(leftDepth, rightDepth) + 1;

    }
}
