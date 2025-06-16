package com.example.algorithm2025.leetcode01.binarySearch;

public class FindMedianSortedArrays1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        //分割线左边所有元素
        //i为第一个数组分割线右边第一个元素(即分割线左边所有元素个数) j为第一个数组分割线右边第一个元素 (即分割线右边所有元素个数)
        //totalLeft = i + j;
        int totalLeft = (m + n + 1) / 2;
        //在nums1的区间[0,m]里查找恰当的分割线
        //使得nums[i - 1] <= num2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;
        while (left < right) {
            int i = (left + right + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                //下一轮搜索区间[left, i - 1]
                right = i - 1;
            } else {
                //下一轮搜素区间[i, right]
                //[left(i), right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ?  Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
