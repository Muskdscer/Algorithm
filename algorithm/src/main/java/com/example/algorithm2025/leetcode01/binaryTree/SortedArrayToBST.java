package com.example.algorithm2025.leetcode01.binaryTree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traveral(nums, 0, nums.length - 1);
    }

    private TreeNode traveral(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traveral(nums, left, mid - 1);
        root.right = traveral(nums, mid + 1, right);
        return root;
    }
}
