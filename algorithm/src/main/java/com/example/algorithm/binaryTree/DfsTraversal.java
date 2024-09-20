package com.example.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class DfsTraversal {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {return;}
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {return;}
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {return;}
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }


}
