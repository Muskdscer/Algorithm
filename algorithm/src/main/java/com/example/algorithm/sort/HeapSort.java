package com.example.algorithm.sort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        //第一次建立大根堆，从后往前依次调整
        for (int i = arr.length/2 -1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            HeapAdjust(arr, i, arr.length);
        }
        //调整堆结构+交换堆顶和末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            HeapAdjust(arr, 0, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void HeapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = 2 * start + 1; i <= end; i = i * 2 + 1) {
            if (i < end && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;
    }
}
