package com.example.algorithm.kamaCoder.binaryTree.levelOrder;
import java.util.*;
import java.io.*;

public class RightSideView {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(char val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, char val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //右视图结果
    static List<Character> res = new ArrayList<>();
    //辅助队列
    static Queue<TreeNode> que = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        TreeNode node1 = new TreeNode('B');
        TreeNode node2 = new TreeNode('C');
        TreeNode node3 = new TreeNode('D');
        TreeNode node4 = new TreeNode('E');
        TreeNode node5 = new TreeNode('F');
        TreeNode node6 = new TreeNode('G');
        TreeNode node7 = new TreeNode('H');
        TreeNode node8 = new TreeNode('I');
        TreeNode node9 = new TreeNode('J');
        TreeNode node10 = new TreeNode('K');

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

        res = rightView(root);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

    }

    private static List<Character> rightView(TreeNode root) {
        if (root == null) {
            return res;
        }

        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }

        return res;
    }
}
