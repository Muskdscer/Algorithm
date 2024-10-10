package com.example.algorithm.leetcode;

public class HeapSortTest {
    public void heapSort(int[] arr) {
        //第一次组成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //交换顺序+调整堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void adjustHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
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
    }
}
