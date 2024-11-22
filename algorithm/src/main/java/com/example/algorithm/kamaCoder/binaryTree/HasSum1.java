package com.example.algorithm.kamaCoder.binaryTree;

public class HasSum1 {
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

    //定义全局变量，用回溯来做
    static int target = 15;
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

        //boolean flag = hasSum(root, 15);

        //用回溯来做
        boolean flag = hasSum(root);

        System.out.println("是否找到：" + flag);
    }

    //每一步不传入target用回溯来保证左右孩子target相同
    private static boolean hasSum(TreeNode root) {
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                return true;
            }

        }

        if (root.left != null) {
            boolean left = hasSum(root.left);
            if (left) {
                return true;
            }
            target += root.left.val;
        }

        if (root.right != null) {
            boolean right = hasSum(root.right);
            if (right) {
                return true;
            }
            target += root.right.val;
        }
        return false;
    }

//    private static boolean hasSum(TreeNode root, int target) {
//        target -= root.val;
//        if (root.left == null && root.right == null) {
//            if (target == 0) {
//                return true;
//            }
//        }
//
//        //左右孩子传进去的target都是一样的，保证了不用回溯
//        if (root.left != null) {
//            boolean left = hasSum(root.left, target);
//            if (left) {
//                return true;
//            }
//        }
//
//        if (root.right != null) {
//            boolean right = hasSum(root.right, target);
//            if (right) {
//                return true;
//            }
//        }
//        return false;
//    }
}
