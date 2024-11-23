package com.example.algorithm.kamaCoder.sort;

import java.lang.*;
import java.util.*;
import java.io.*;

public class HeapSort {

    static int[] nums = new int[]{3, 4, 6, 1, 2, 4, 7};
    public static void main(String[] args) {
        heapSortNew(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void heapSortNew(int[] nums) {
        //第一次调整堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            Adjust(nums, i, nums.length - 1);
        }
        //交换+调整
        for (int i = nums.length - 1; i > 0; i--) {
            swapNew(nums, 0, i);
            Adjust(nums, 0, i);
        }
    }

    private static void swapNew(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void Adjust(int[] nums, int start, int end) {
        int temp = nums[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if (i < end && nums[i + 1] > nums[i]) {
                i++;
            }

            if (i < end && nums[i] > temp) {
                nums[start] = nums[i];
                start = i;
            } else {
                break;
            }
        }
    }
}
