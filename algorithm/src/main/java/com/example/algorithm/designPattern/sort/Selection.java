package com.example.algorithm.designPattern.sort;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 不稳定  最佳O(n^2) 最差O(n^2)
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
