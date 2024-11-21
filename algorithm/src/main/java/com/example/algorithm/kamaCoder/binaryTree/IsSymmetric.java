package com.example.algorithm.kamaCoder.binaryTree;

public class IsSymmetric {
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

        boolean isFlag = isSymetric(root);
    }

    private static boolean isSymetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right == null || root.left == null && root.right != null) {
            return  false;
        }

        if (root.left.val == root.right.val) {
            return true;
        }
        if (root.left.val != root.right.val) {
            return false;
        }

        boolean leftFlag = isSymetric(root.left);
        boolean rightFlag = isSymetric(root.right);
        return leftFlag && rightFlag;
    }

    private static boolean isSymetric1(TreeNode root) {
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        if(left.val == right.val) {
            return true;
        }

        boolean out = compare(left.left, right.right);
        boolean in = compare(left.right, right.left);
        return out && in;
    }


}
