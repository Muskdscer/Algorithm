package com.example.algorithm.kamaCoder.binaryTree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {

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

    //层最大值
    static int depth = 0;
    //辅助队列
    static Queue<TreeNode> que = new LinkedList<>();
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

        depth = maxDepth(root);
        System.out.println("最大深度： "  + depth);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return depth;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
