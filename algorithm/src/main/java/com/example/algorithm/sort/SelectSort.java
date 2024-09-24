package com.example.algorithm.sort;

public class SelectSort {
    public void selectSort(int[] arr) {
        int length = arr.length;
        int minIndex;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //外部循环来控制：数据的排序，得到最小值进行和第一个元素进行交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
