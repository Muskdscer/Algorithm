package com.example.algorithm.kamaCoder.sort;

import java.lang.*;
import java.util.*;
import java.io.*;

public class MergeSort {

    static int[] nums = new int[]{3, 4, 6, 1, 2, 4, 7};
    public static void main(String[] args) {
        int[] temp = new int[nums.length];
        mergeSortNew(nums, 0, 6, temp);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void mergeSortNew(int[] nums, int left, int right, int[] temp) {
        //求中间索引
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSortNew(nums, left, mid, temp);
            mergeSortNew(nums, mid + 1, right, temp);
            mergeNew(nums, left, mid, right, temp);
        }
    }

    private static void mergeNew(int[] nums, int left, int mid, int right, int[] temp) {
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
