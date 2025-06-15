package com.example.algorithm2025.leetcode01.binarySearch;

public class Search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0, right = len - 1;
        //旋转过后 从中间划分 一定有一边是有序得
        //根据边界值判断目标值是在有序一遍还是无序一边
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //右边有序
            if (nums[mid] < nums[right]) {
                //目标值在右边
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    //目标值在左边
                    right = mid - 1;
                }
            } else {
                //左边有序
                //目标值在左边
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    //目标值在右边
                    left = mid + 1;
                }
            }

        }
        return -1;
    }
}
