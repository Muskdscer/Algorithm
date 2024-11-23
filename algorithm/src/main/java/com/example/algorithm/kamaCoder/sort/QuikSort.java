package com.example.algorithm.kamaCoder.sort;

import java.lang.*;
import java.util.*;
import java.io.*;


public class QuikSort {
    static int[] nums = new int[]{3, 4, 6, 1, 2, 4, 7};
    public static void main(String[] args) {
        quickSortDemo(nums, 0 ,nums.length - 1);
        for (int i = 0; i <= nums.length - 1; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void quickSortDemo(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = getIndex(nums, left, right);

            quickSortDemo(nums, left, pivot - 1);
            quickSortDemo(nums, pivot + 1, right);
        }
    }

    private static int getIndex(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (nums[right] < pivot) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (nums[left] > pivot) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        return left;
    }
}
