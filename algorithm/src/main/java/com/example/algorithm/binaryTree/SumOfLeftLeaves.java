package com.example.algorithm.binaryTree;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValeue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            midValeue = root.left.val;
        }
        int sum = leftValue + rightValue + midValeue;
        return sum;
    }
}
