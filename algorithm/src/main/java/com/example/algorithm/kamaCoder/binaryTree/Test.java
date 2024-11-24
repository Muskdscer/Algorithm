package com.example.algorithm.kamaCoder.binaryTree;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Test {
    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {

        }
        public TreeNode(char val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, char val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    static Map<Character, Integer> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            String pre = s[0];
            String in = s[1];
            TreeNode root = build(pre, in);
            printTree(root);
        }
    }

    private static void printTree(TreeNode root) {

    }

    private static TreeNode build(String pre, String in) {
        if (pre.length() == 0 || in.length() == 0) {
            return null;
        }
        for (int i = 0; i < in.length(); i++) {
            map.put(in.charAt(i), i);
        }

        TreeNode root = buildHelper(pre.toCharArray(), 0, pre.length() - 1, in.toCharArray(), 0, in.length() -1);

        //翻转
        TreeNode rootNew = swap(root);
        return rootNew;
    }

    private static TreeNode swap(TreeNode root) {
        if (root == null) {
            return null;
        }


        swap(root.left);
        swap(root.right);
        swapHelper(root);
        return root;
    }

    private static void swapHelper(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private static TreeNode buildHelper(char[] pre, int preStart, int preEnd, char[] in, int inStart, int inEnd) {
        if (preEnd < 0 || preStart > preEnd || inStart < 0 || inStart > inEnd) {
            return null;
        }
        if (preEnd > pre.length- 1 || inEnd > in.length - 1) {
            return null;
        }

        char midValue = pre[preStart];
        TreeNode root = new TreeNode(midValue);
        Integer rootIndex = map.get(midValue);
        int lenOfLeft = rootIndex - preStart;

        root.left = buildHelper(pre, preStart + 1, preStart + lenOfLeft, in, inStart, rootIndex - 1);
        root.right = buildHelper(pre, preStart + lenOfLeft + 1, preEnd, in, rootIndex + 1, inEnd);
        return root;
    }
}
