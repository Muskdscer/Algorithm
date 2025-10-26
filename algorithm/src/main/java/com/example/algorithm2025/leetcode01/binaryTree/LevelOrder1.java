package com.example.algorithm2025.leetcode01.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder1 {
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
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                level.add(poll.val);
                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
