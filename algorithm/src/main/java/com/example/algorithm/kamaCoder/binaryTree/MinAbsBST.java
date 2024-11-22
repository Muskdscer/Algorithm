package com.example.algorithm.kamaCoder.binaryTree;

public class MinAbsBST {
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

    static int minValue = Integer.MAX_VALUE;
    static int value;
    //记录上一个节点
    static TreeNode pre;
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

        minAbsBST(root);
        System.out.println("最小绝对值差是：" + minValue);
    }

    private static int minAbsBST(TreeNode root) {
        //左
        if (root == null) {
            return 0;
        }
        getDifference(root);
        return minValue;
    }

    private static void getDifference(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        getDifference(root.left);

        //中
        if (pre != null) {
            minValue = Math.min(Math.abs(root.val - pre.val), minValue);
        }
        pre = root;

        //右
        getDifference(root.right);
    }
}
