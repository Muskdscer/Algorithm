package com.example.algorithm2025.leetCode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> que = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i <size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
