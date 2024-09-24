package com.example.algorithm.sort;

public class ShellSort {
    public static void shellSort(int[] arr)
    {
        int n = arr.length;

        // 初始增量（间隔）为数组长度的一半
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 从gap开始对数组进行插入排序
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;
                // 对每个元素进行间隔为gap的插入排序
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }
}
