package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pathsum {
    public List<List<Integer>> pathsum(TreeNode root, int targetsum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;// 非空判断
        }

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetsum, res, path);
        return res;
    }

    public void preorderdfs(TreeNode root, int targetsum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetsum 的路径
            if (targetsum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetsum，返回
        }

        if (root.left != null) {
            preorderdfs(root.left, targetsum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
        if (root.right != null) {
            preorderdfs(root.right, targetsum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
    }
}
