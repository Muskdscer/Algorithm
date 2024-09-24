package com.example.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[]= {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, 7, temp);
    }

    /**
     * 纸上画出来递归顺序
     * @param arr  排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param right  右边索引
     * @param temp  做中转的数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp)
    {
        //求中间索引
        int mid = (left + right) / 2;

        if (left < right) {
            //左边递归分解
            mergeSort(arr, left, mid, temp);
            //右边递归分解
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
            System.out.println(" 最左边索引:"+left+"\t最右边边索引:"+right+"\t"+ Arrays.toString(arr));
        }
    }

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引
     * @param right   右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
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
