package com.example.algorithm.kamaCoder.binaryTree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average {
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

    //层平均值
    static List<Double> res = new ArrayList<>();
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

        res = average(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    //层平均值
    private static List<Double> average(TreeNode root) {
        if (root == null) {
            return res;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            double sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                sum += node.val;
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            double aver = sum / size;
            res.add(aver);
        }

        return res;
    }


}
