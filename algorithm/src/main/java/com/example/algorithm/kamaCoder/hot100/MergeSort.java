package com.example.algorithm.kamaCoder.hot100;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums =  new int[]{3,2,1,5,6,4};
        int[] temp = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        merge(nums, 0, 5, temp);
    }

    private static void merge(int[] nums, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            merge(nums, left, mid, temp);
            merge(nums, mid + 1, right, temp);
            mergeSort(nums, left, mid, right, temp);
        }
    }

    private static void mergeSort(int[] nums, int left, int mid, int right, int[] temp) {
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
