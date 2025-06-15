package com.example.algorithm2025.leetcode01.binarySearch;

public class SearchRange1 {
    public int[] searchRange1(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        //寻找第一个
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        result[0] = first;

        //寻找第二个
        left = 0;
        right = nums.length - 1;
        int last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        result[1] = last;
        return result;
    }
}
