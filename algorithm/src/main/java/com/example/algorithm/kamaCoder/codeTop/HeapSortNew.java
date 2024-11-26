package com.example.algorithm.kamaCoder.codeTop;

public class HeapSortNew {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        heapSortNew1(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void heapSortNew1(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            AdjustHeap(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            swap11(nums, 0, i);
            AdjustHeap(nums, 0, i);
        }
    }

    private static void AdjustHeap(int[] nums, int start, int end) {
        int temp = nums[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if (i < end && nums[i + 1] > nums[i]) {
                i++;
            }

            if (i < end && nums[i] > temp) {
                nums[start] = nums[i];
                start = i;
            } else {
                break;
            }
        }
    }

    private static void swap11(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
