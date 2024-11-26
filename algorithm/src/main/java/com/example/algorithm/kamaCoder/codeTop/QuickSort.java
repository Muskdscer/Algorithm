package com.example.algorithm.kamaCoder.codeTop;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSortNew(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void quickSortNew(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = getIndexNew(nums, left, right);
            quickSortNew(nums, left, pivot - 1);
            quickSortNew(nums, pivot + 1, right);
        }
    }

    private static int getIndexNew(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (nums[right] < pivot) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (nums[left] > pivot) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        return left;
    }
}
