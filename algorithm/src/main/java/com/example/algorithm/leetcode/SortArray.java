package com.example.algorithm.leetcode;

public class SortArray {
    public int [] sortArray(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        int[] newNums = quikSort(nums, left, right);
        return newNums;
    }

    private int[] quikSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quikSort(nums, left, pivot - 1);
            quikSort(nums, pivot + 1, right);
        }
        return nums;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
