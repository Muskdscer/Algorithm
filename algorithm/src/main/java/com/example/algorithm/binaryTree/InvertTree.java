package com.example.algorithm.binaryTree;

import java.util.ArrayDeque;

public class InvertTree {
    public TreeNode dfsInvertTree(TreeNode root)
    {
        if (root == null) {
            return null;
        }
        dfsInvertTree(root.left);
        dfsInvertTree(root.right);
        swapChildren(root);
        return root;
    }
    public void swapChildren(TreeNode root)
    {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode iterInvertTree(TreeNode root)
    {
        if (root == null){
            return null;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque();
        deque.offer(root);
        while (!deque.isEmpty())
        {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }
    public void swap(TreeNode node)
    {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
