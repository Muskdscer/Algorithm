package com.example.algorithm.kamaCoder.binaryTree;

public class HasSum {
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

        boolean flag = hasSum(root, 20, 0);
    }

    private static boolean hasSum(TreeNode root, int sum, int temp) {
        if (root == null) {
            return false;
        }

        temp += root.val;
        if (root.left == null && root.right == null) {
            if (temp == sum) {
                return true;
            }
        }

        boolean left = false;
        if (root.left != null) {
            left = hasSum(root.left, sum, temp);
            temp -= root.left.val;
        }

        boolean right = false;
        if (root.right != null) {
            right = hasSum(root.right, sum, temp);
            temp -= root.right.val;
        }

        return left && right;
    }
}
