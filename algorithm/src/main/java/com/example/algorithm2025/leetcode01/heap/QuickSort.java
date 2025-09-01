package com.example.algorithm2025.leetcode01.heap;

public class QuickSort {
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        //每一次pivot都是拿出来，以这个为基准 比他小的方左边 比他大的放右边
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= arr[right]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
