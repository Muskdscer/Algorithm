package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void radixSort(int[] arr)
    {
        //获取数组中最大值
        int max = Arrays.stream(arr).max().getAsInt();
        //从个位开始，对数组进行基数排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // 按位数进行计数排序的辅助函数
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // 输出数组
        int[] count = new int[10]; // 计数数组，范围为 0-9

        // 初始化计数数组为 0
        Arrays.fill(count, 0);

        // 统计每个桶中的元素个数
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // 将计数数组转换为实际位置数组
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 按当前位数将元素放入输出数组中
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 将排序好的元素复制回原数组
        System.arraycopy(output, 0, arr, 0, n);
    }
}
