package com.example.algorithm.kamaCoder.binaryTree;

public class FindBottomLeftValue2 {
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

    static int DEEP = -1;
    static int val;
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

        findBL(root, 0);

        System.out.println("最底层左下角的值为： " + val);
    }

    private static void findBL(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > DEEP) {
                DEEP = deep;
                val = root.val;
            }
        }
        //左节点和右节点传进去的参数deep是一样的，都是从上面方法里面传进来的
        //同一层的左右孩子的deep值是一样的，但是经过计算得到的DEEP值可能不一样了
        findBL(root.left, deep + 1);
        findBL(root.right, deep + 1);
    }
}
