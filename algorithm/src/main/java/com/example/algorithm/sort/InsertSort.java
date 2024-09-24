package com.example.algorithm.sort;

public class InsertSort {
    public int[] insertSort(int[] arr) {
        int length = arr.length;
        if (length < 0) {
            return null;
        } {
            for (int i = 0; i < length - 1; i++) {
                int current = arr[i + 1];
                int index = i;
                while(index >= 0 && current < arr[index]) {
                    arr[index + 1] = arr[index];
                    index--;
                }
                arr[index + 1] = current;
            }
        }
        return arr;
    }
}
