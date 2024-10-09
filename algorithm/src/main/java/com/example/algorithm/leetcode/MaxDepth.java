package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun02(root);
        return resList;
    }

    public void checkFun02(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
            resList.add(itemList);
        }
    }
}
