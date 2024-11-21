package com.example.algorithm.kamaCoder.binaryTree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnetII {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode next;
        public TreeNode() {}
        public TreeNode(char val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, TreeNode next, char val) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    //收集结果
    static List<Character> res = new ArrayList<>();
    //辅助队列
    static Queue<TreeNode> que = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode('1');
        TreeNode node1 = new TreeNode('2');
        TreeNode node2 = new TreeNode('3');
        TreeNode node3 = new TreeNode('4');
        TreeNode node4 = new TreeNode('5');
        TreeNode node5 = new TreeNode('6');
        TreeNode node6 = new TreeNode('7');
        TreeNode node7 = new TreeNode('8');
        TreeNode node8 = new TreeNode('9');


        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;

        res = connectMethod(root);
        for (Character re : res) {
            System.out.println(re);
        }
    }

    private static List<Character> connectMethod(TreeNode root) {
        if (root == null) {
            return res;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = null;
            TreeNode nodePre = null;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    node = que.poll();//取出本层第一个节点
                    nodePre = node;
                } else {
                    node = que.poll();
                    nodePre.next = node;
                    nodePre= nodePre.next;
                }

                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            nodePre.next = null;
        }
        return res;
    }


}
