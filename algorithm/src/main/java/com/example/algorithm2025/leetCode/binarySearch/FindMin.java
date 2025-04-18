package com.example.algorithm2025.leetCode.binarySearch;

public class FindMin {
    public int findMin(int[] nums) {
        //二分左闭右闭
        //其实就是把原有序数组后面一部分递增段移到了数组前面
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {//根本提特殊性  =会导致死循环
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[len - 1]) {
                //证明nums[mid]在第一段 最小值在第二段
                left = mid + 1;
            } else {
                //nums[mid]在第二段 最小值就是他或者他左边 所以要包含mid
                right = mid;
            }
        }
        //最终循环退出 left和right都指向了最小值
        return nums[right];
    }
}
