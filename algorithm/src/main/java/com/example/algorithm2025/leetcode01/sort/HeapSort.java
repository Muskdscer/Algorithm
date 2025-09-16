package com.example.algorithm2025.leetcode01.sort;

public class HeapSort {
    public int findKthLargest(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            HeapAdjust(nums, 0, i - 1);
        }
        return nums[0];
    }

    public void HeapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for(int i = 2 * start + 1; i <= end; i = i * 2 + 1) {
            if(i < end && arr[i] < arr[i+1]) {
                i++;
            }
            if(arr[i] > temp) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
