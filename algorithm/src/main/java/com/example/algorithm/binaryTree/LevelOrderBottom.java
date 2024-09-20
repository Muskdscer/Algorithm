package com.example.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) return list;
        que.offerLast(root);
        while (!que.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();

            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode peek = que.peekFirst();
                levelList.add(que.pollFirst().val);
                if (peek.left != null) que.offerLast(peek.left);
                if (peek.right != null) que.offerLast(peek.right);
            }
            list.add(levelList);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }
}
