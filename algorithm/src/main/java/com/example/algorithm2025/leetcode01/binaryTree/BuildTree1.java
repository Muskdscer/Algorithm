package com.example.algorithm2025.leetcode01.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree1 {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        Integer rootIndex = map.get(preorder[preStart]);
        int leftLen = rootIndex - inStart;
        root.left = buildHelper(preorder, preStart + 1, preStart + leftLen, inorder, inStart, rootIndex - 1);
        root.right = buildHelper(preorder,  preStart + leftLen + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
