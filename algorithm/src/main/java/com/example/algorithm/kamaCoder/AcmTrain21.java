package com.example.algorithm.kamaCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AcmTrain21 {
    public static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            String pre = ss[0];
            String in = ss[1];
            //构建二叉树
            //前序 中序
            TreeNode root = buildTree(pre.toCharArray(), in.toCharArray());
            printTree(root);
            System.out.println();
        }
    }

    public static TreeNode buildTree(char[] pre, char[] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        TreeNode res = helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return res;
    }

    public static TreeNode helper(char[] pre, int preStart, int preEnd, char[] in, int inStart, int inEnd) {
        if (preStart < 0 || preStart > preEnd || inStart < 0 || inStart > inEnd) {
            return null;
        }
        if (preEnd > pre.length -1 || inEnd > in.length - 1) {
            return null;
        }

        char headVal = pre[preStart];
        Integer headIndex = map.get(headVal);
        int lengthOfLeft = headIndex - inStart;
        TreeNode root = new TreeNode(headVal);
        root.left = helper(pre, preStart + 1, preStart + lengthOfLeft, in, inStart, headIndex - 1);
        root.right = helper(pre, preStart + 1 +lengthOfLeft, preEnd, in, headIndex + 1, inEnd);
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        printTree(root.right);
        System.out.print(root.val);
    }
}
