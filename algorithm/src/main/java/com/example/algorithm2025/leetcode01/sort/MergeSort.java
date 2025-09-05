package com.example.algorithm2025.leetcode01.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        merge(arr, 0, 7, temp);
    }

    public static void merge(int[] arr, int left, int right, int[] temp) {
        //求中间索引
        int mid = (left + right) / 2;
        if (left < right) {
            //左边递归分解
            merge(arr, left, mid, temp);
            //右边递归分解
            merge(arr, mid + 1, right, temp);
            mergeAll(arr, left, mid, right, temp);
        }
    }
    private static void mergeAll(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        int n = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[n++];
        }
    }
}
