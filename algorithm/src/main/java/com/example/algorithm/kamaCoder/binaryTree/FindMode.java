package com.example.algorithm.kamaCoder.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindMode {
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

    static List<Integer> res =  new ArrayList<>();
    static TreeNode pre = null;
    static int count = 1;
    static int maxCount = 1;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        findMode(root);

        for (Integer re : res) {
            System.out.println("二叉搜索树中的众数为：" + re);
        }
    }

    private static void findMode(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        findMode(root.left);

        //中
        if (pre == null) {
            count = 1;
        } else if (pre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        pre = root;
        if (count == maxCount) {
            res.add(root.val);
        }

        if (count > maxCount) {
            maxCount = count;
            res.clear();//很关键的一步，不要忘记清空result，遇到最大的频率之后 之前result里的元素都失效了
            res.add(root.val);
        }

        //右
        findMode(root.right);
    }
}
