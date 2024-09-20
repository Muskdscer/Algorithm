package com.example.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public int minDepth(TreeNode root)
    {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            TreeNode cur = null;
            for (int i = size; i > 0; i--) {
                cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return depth;
    }
}
