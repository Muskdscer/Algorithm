package com.example.algorithm2025.leetcode01.binarySearch;

public class FindMin {
    public int findMin(int[] nums) {
        //二分左闭右闭
        //其实就是把原有序数组后面一部分递增段移到了数组前面
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {// =会导致死循环
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                //最小值在第二段
                left = mid + 1;
            } else {
                //最小值在第一段
                right = mid;
            }
        }
        //最终循环退出 left和right都指向了最小值
        return nums[right];
    }
}
