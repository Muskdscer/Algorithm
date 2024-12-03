package com.example.algorithm.kamaCoder.hot100;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums =  new int[]{3,2,1,5,6,4};
        int left = 0;
        int right = nums.length - 1;
        getReuslt(nums, left, right);
    }

    private static void getReuslt(int[] nums, int left, int right) {
        int mid = getNumber(nums, left, right);
        if (left < right) {
            getReuslt(nums, left, mid - 1);
            getReuslt(nums, mid + 1, right);
        }
    }

    private static int getNumber(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right && nums[right] < pivot) {
                nums[left] = nums[right];
                left++;
            }

            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right && nums[left] > pivot) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        return left;
    }
}
