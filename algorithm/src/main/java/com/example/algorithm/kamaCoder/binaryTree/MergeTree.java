package com.example.algorithm.kamaCoder.binaryTree;
import java.util.*;
import java.io.*;

public class MergeTree {
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
        TreeNode rootA = new TreeNode(1);
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

        rootA.left = node1;
        rootA.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;
        node4.left = node9;
        node4.right = node10;

        TreeNode rootB = rootA;

        TreeNode root = mergeTrees(rootA, rootB);
        System.out.println("新二叉树根节点为： " + root.val);
    }

    private static TreeNode mergeTrees(TreeNode rootA, TreeNode rootB) {
        if (rootA == null) {
            return rootB;
        }
        if (rootB == null) {
            return rootA;
        }

        int rootVal = rootA.val + rootB.val;
        TreeNode root = new TreeNode(rootVal);

        rootA.left = mergeTrees(rootA.left, rootB.left);
        rootA.right = mergeTrees(rootA.right, rootB.right);
        return root;
    }
}
