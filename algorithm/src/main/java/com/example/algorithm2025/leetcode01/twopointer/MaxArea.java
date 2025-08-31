package com.example.algorithm2025.leetcode01.twopointer;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            } else {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }
}
