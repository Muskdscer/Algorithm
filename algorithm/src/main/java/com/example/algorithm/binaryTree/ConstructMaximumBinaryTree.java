package com.example.algorithm.binaryTree;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums)
    {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }
    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex)
    {
        if (rightIndex - leftIndex <= 0) {
            return null;
        }
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;//最大值所在的位置
        int maxValue = nums[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }


}
