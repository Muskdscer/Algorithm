package com.example.algorithm.kamaCoder.binaryTree;

import java.util.*;
import java.io.*;

public class ConstructMaxTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[6];
        while (sc.hasNextInt()) {
            int num0 = sc.nextInt();
            nums[0]= num0;
            int num1 = sc.nextInt();
            nums[1]= num1;
            int num2 = sc.nextInt();
            nums[2]= num2;
            int num3 = sc.nextInt();
            nums[3]= num3;
            int num4 = sc.nextInt();
            nums[4]= num4;
            int num5 = sc.nextInt();
            nums[5]= num5;

            TreeNode root = constructMaximumBinaryTree1(nums, 0, nums.length);
        }
    }

    private static TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }

        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }

        int maxIndex = leftIndex;
        int maxValue = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);
        //根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }
}
