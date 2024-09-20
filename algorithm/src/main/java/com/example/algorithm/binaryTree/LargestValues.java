package com.example.algorithm.binaryTree;

import java.util.*;

public class LargestValues {
    public List<Integer> largestValues(TreeNode root)
    {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode poll = queue.poll();
                max = Math.max(max, poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            result.add(max);
        }
        return result;
    }
}
