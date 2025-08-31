package com.example.algorithm2025.leetcode01.twopointer;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length; int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int leftNum = nums[left];
        nums[left] = nums[right];
        nums[right] = leftNum;
    }
}
