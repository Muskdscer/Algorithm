package com.example.algorithm2025.leetCode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> que = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i <size; i++) {
                TreeNode node = que.poll();
                level.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
