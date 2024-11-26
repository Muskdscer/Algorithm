package com.example.algorithm.kamaCoder.codeTop;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] temp = new int[nums.length];
        mergeSortNew11(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSortNew11(int[] nums, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSortNew11(nums, left, mid, temp);
            mergeSortNew11(nums, mid + 1, right, temp);
            mergeNew11(nums, left, mid, right, temp);
        }
    }

    private static void mergeNew11(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t] = nums[i];
                t++;
                i++;
            } else {
                temp[t] = nums[j];
                t++;
                j++;
            }

            while (i <= mid) {
                temp[t] = nums[i];
                t++;
                i++;
            }
            while (j <= right) {
                temp[t] = nums[j];
                t++;
                j++;
            }
            int n = 0;
            int tempLeft = left;
            while (tempLeft <= right) {
                nums[tempLeft++] = temp[n++];
            }
        }
    }
}
