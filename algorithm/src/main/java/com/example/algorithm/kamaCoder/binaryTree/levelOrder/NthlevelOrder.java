package com.example.algorithm.kamaCoder.binaryTree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NthlevelOrder {
    /**
     * N叉树定义
     */
    static class NthNode {
        int val;
        List<NthNode> children;
        public NthNode() {
        }

        public NthNode(int val) {
            this.val = val;
        }

        public NthNode(int val, List<NthNode> children) {
            this.val = val;
            this.children = children;
        }
    }

    //收集结果集合
    static List<List<Integer>> res = new ArrayList<>();
    //辅助队列
    static Queue<NthNode> que = new LinkedList<>();
    public static void main(String[] args) {
        NthNode root = new NthNode(1);
        NthNode node1 = new NthNode(2);
        NthNode node2 = new NthNode(3);
        NthNode node3 = new NthNode(4);
        NthNode node4 = new NthNode(5);
        NthNode node5 = new NthNode(6);
        NthNode node6 = new NthNode(7);
        NthNode node7 = new NthNode(8);
        NthNode node8 = new NthNode(9);
        NthNode node9 = new NthNode(10);
        NthNode node10 = new NthNode(11);

        List<NthNode> rootChildren = new ArrayList<>();
        rootChildren.add(node1);
        rootChildren.add(node2);
        root.children = rootChildren;
        List<NthNode> node2Children = new ArrayList<>();
        node2Children.add(node3);
        node2Children.add(node4);
        node2Children.add(node5);
        node2.children = node2Children;
        List<NthNode> node3Children = new ArrayList<>();
        node3Children.add(node6);
        node3Children.add(node7);
        node3Children.add(node8);
        node3Children.add(node9);
        node3Children.add(node10);
        node3.children = node3Children;


        res = NlevelOrder(root);
        System.out.println("收集层数为: " + res.size());
    }

    private static List<List<Integer>> NlevelOrder(NthNode root) {
        if (root == null) {
            return res;
        }

        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                NthNode nthNode = que.poll();
                tempList.add(nthNode.val);

                List<NthNode> children = nthNode.children;
                if (children.size() != 0) {
                    for (int j = 0; j < children.size(); j++) {
                        que.offer(children.get(j));
                    }
                }
                res.add(tempList);
            }
        }
        return res;
    }
}
