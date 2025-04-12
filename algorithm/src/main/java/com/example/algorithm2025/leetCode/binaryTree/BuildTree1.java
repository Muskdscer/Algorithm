package com.example.algorithm2025.leetCode.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree1 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        //左闭右闭
        return BuildByPreAndIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode BuildByPreAndIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootIndex = map.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        int lenOfLeft = rootIndex - inStart;
        root.left = BuildByPreAndIn(preorder, preStart + 1, preStart + lenOfLeft, inorder, inStart, inStart + lenOfLeft - 1);
        root.right = BuildByPreAndIn(preorder, preStart + lenOfLeft + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
