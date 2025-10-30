package com.example.algorithm2025.leetcode01.binaryTree;

import java.util.*;

public class ZlevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        List<List<Integer>> res = new ArrayList<>();
        res = levelOrder(root);
        for(int i = 0; i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curlevel = new ArrayList<>();
            while (size > 0) {
                TreeNode remove = queue.remove();
                curlevel.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
                size--;
            }
            if (flag == false) {
                Collections.reverse(curlevel);
            }
            ans.add(curlevel);
            flag = !flag;
        }
        return ans;
    }
}
