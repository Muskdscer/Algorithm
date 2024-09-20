package com.example.algorithm.designPattern.sort;

import java.util.Arrays;

public class Quik1 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,3,6,4};
        System.out.println("原始数组："+ Arrays.toString(arr));
        quickSort1(arr,0,arr.length - 1);
        System.out.println("排序后的数组："+ Arrays.toString(arr));
    }
    public static void quickSort1(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition1(arr, left, right);
            quickSort1(arr, left, pivot - 1);
            quickSort1(arr, pivot + 1, right);
        }
    }

    public static int partition1(int[] arr, int left, int right) {
        int pivotInex = arr[right];
        int pointer = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotInex) {
                int temp = arr[pointer];
                arr[pointer] = arr[i];
                arr[i] = temp;
                pointer++;
            }
        }

        int temp = arr[pointer];
        arr[pointer] = arr[right];
        arr[right] = temp;
        return pointer;
    }
}
