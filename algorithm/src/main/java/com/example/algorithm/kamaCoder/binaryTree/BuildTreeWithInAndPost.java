package com.example.algorithm.kamaCoder.binaryTree;
import java.util.*;
import java.io.*;


public class BuildTreeWithInAndPost {
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

    //辅助空间
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] strings = sc.nextLine().split(" ");
            String in = strings[0];
            String post = strings[1];
            TreeNode root = build(post, in);
            printTreePre(root);
        }
    }

    private static void printTreePre(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printTreePre(root.left);
        printTreePre(root.right);
    }

    private static TreeNode build(String post, String in) {
        if (post.length() == 0 || in.length() == 0) {
            return null;
        }
        for (int i = 0; i < in.length(); i++) {
            map.put(in.charAt(i) - '0', i);
        }
        int[] postArray = new int[post.length()];
        int[] inArray = new int[in.length()];
        for (int i = 0; i < post.length(); i++) {
            postArray[i] = post.charAt(i) - '0';
        }

        for (int i = 0; i < in.length(); i++) {
            inArray[i] = in.charAt(i) - '0';
        }

        TreeNode root = buildHelper(postArray, 0, postArray.length -1, inArray, 0, inArray.length -1);
        return root;
    }

    private static TreeNode buildHelper(int[] postArray, int pStart, int pEnd, int[] inArray, int inStart, int inEnd) {
        if (pStart < 0 || pStart > pEnd || inStart < 0 || inStart > inEnd) {
            return null;
        }

        if (pEnd > postArray.length - 1 || inEnd > inArray.length - 1) {
            return null;
        }

        int midValue = postArray[pEnd - 1];
        TreeNode root = new TreeNode(midValue);
        Integer rootIndex = map.get(midValue);
        int lengthOfLeft = rootIndex - inStart;
        root.left = buildHelper(postArray, pStart, pStart + lengthOfLeft, inArray, inStart, rootIndex -1);
        root.right = buildHelper(postArray, pStart + lengthOfLeft + 1,pEnd -1,  inArray,rootIndex + 1, inEnd);
        return root;
    }
}
