package com.example.algorithm2025.leetcode01.heap;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        //第一个非叶子节点调整
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(nums, i, nums.length - 1);
        }
        //先调换 再调整
        for (int i = nums.length - 1; i > nums.length - k; i--) {
            //调换
            swap(nums, 0, i);
            //调整
            HeapAdjust(nums, 0, i - 1);
        }
        return nums[0];
    }

    private void HeapAdjust(int[] nums, int start, int end) {
        int temp = nums[start];
        for (int i = start * 2 + 1; i <= end; i = i * 2 + 1) {
            if (nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[i] > temp) {
                nums[start] = nums[i];
                start = i;
            } else {
                break;
            }
            nums[start] = temp;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
