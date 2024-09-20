package com.example.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root)
    {
        List<Double> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) return list;
        que.offerLast(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();
                sum += poll.val;
                if (poll.left != null) que.addLast(poll.left);
                if (poll.right != null) que.addLast(poll.right);
            }
           list.add(sum / levelSize);
        }
        return list;
    }
}
