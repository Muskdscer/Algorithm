package com.example.algorithm2025.leetCode.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree1 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = BuildByPreAndIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode BuildByPreAndIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootIndex = map.get(inorder[inStart]);
        TreeNode root = new TreeNode(val);
    }


}
