package com.example.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root)
    {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = size; i > 0; i--) {
                TreeNode poll = que.poll();
                if (poll.left != null) que.offer(poll.left);
                if (poll.right != null) que.offer(poll.right);
            }
            depth++;
        }
        return depth;
    }
}
