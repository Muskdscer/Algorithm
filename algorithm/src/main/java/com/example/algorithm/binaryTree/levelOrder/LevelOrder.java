package com.example.algorithm.binaryTree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun02(root);
        return resList;
    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);
        while (!que.isEmpty()){
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode treeNode = que.poll();
                itemList.add(treeNode.val);

                if (treeNode.left != null) {
                    que.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    que.offer(treeNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
    }
}
