package com.example.algorithm.kamaCoder.binaryTree;
import java.util.*;
import java.io.*;


public class Iterator {
    static class TreeNode {
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
    //辅助空间
    static Map<Character,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            String pre = strs[0];
            String in = strs[1];
            TreeNode root = build(pre.toCharArray(), in.toCharArray());
//            printBinaryTree(root);

            //迭代遍历-前序
//            preorderTraversal(root);
            //迭代遍历-后序
            postorderTraversal(root);
            System.out.println();
        }
    }

    private static List<TreeNode> postorderTraversal(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    private static List<TreeNode> preorderTraversal(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

    private static TreeNode build(char[] pre, char[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }


        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        TreeNode root = builHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode builHelper(char[] pre, int preStart, int preEnd, char[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        char c = pre[preStart];
        TreeNode root = new TreeNode(c);
        int rootIndex = map.get(c);
        int lengthOfleft = rootIndex - inStart;

        root.left = builHelper(pre, preStart + 1, preStart + lengthOfleft, in, inStart, rootIndex - 1);
        root.right = builHelper(pre, preStart + lengthOfleft + 1, preEnd, in,rootIndex + 1, inEnd);
        return root;
    }

    private static void printBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printBinaryTree(root.left);
        printBinaryTree(root.right);
        System.out.println(root.val);
    }
}
