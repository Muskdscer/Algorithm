package com.example.algorithm.sort;

/**
 * 最优的时间复杂度为：O( n^2 ) ；有的说 O(n)
 * 最差的时间复杂度为：O( n^2 )
 * 平均的时间复杂度为：O( n^2 )
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - j; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //优化
    public static void bubbleSort2(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            //如果没有进入交换，说明已经排好序了
            //如果进入了交换，把flag设置为false，判断下一次循环是否进入交换
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
