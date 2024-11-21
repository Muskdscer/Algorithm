package com.example.algorithm.kamaCoder.binaryTree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connect {

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
    static TreeNode pre = null;
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
            int size = que.size();
//            for(int i = 0; i < size; i++) {
//                TreeNode node1 = que.poll();
//                TreeNode node2 = que.poll();
//                if (node1 != null && node2 == null) {
//                    res.add(node1.val);
//                    res.add('#');
//                    if (node1.left != null) {
//                        que.offer(node1.left);
//                    }
//                    if (node1.right != null) {
//                        que.offer(node1.right);
//                    }
//                } else if (node1 != null && node2 != null){
//                    res.add(node1.val);
//                    res.add(node2.val);
//
//                    if (node1.left != null) {
//                        que.offer(node1.left);
//                    }
//                    if (node1.right != null) {
//                        que.offer(node1.right);
//                    }
//
//
//                    if (node2.left != null) {
//                        que.offer(node2.left);
//                    }
//                    if (node2.right != null) {
//                        que.offer(node2.right);
//                    }
//                } else if (node1 == null && node2 == null){
//                    continue;
//                }
//            }

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }

                for (int j = 1; j < size; j++) {
                    TreeNode nextNode = que.poll();
                    if (nextNode.left != null) {
                        que.offer(nextNode.left);
                    }
                    if (nextNode.right != null) {
                        que.offer(nextNode.right);
                    }
                    node.next = nextNode;
                    node = nextNode;
                }
            }
            return res;
        }

        return res;
    }
}
