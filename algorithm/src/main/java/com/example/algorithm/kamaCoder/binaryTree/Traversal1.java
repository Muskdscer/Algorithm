package com.example.algorithm.kamaCoder.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traversal1 {
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

    //收集结果
    static List<String> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
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

        traversal(root, res, temp);
    }

    private static void traversal(TreeNode root, List<String> res, List<Integer> temp) {
        //前序
        temp.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.size() - 1; i++) {
                sb.append(temp.get(i)).append("->");
            }
            sb.append(temp.get(temp.size() - 1));
            res.add(sb.toString());
        }

        if (root.left != null) {
            traversal(root.left, res, temp);
            temp.remove(temp.size() - 1);
        }

        if (root.right != null) {
            traversal(root.right, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
