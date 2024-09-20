package com.example.algorithm.designPattern.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 稳定  最佳O(n) 最差O()
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //flag change
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
