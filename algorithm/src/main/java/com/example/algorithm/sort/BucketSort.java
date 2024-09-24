package com.example.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序
 */
public class BucketSort {
    public static void bucketSort(float[] arr, int numBuckets) {
        if (arr.length <= 1) {return;}

        // 创建桶
        ArrayList<Float>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 将元素分配到桶中
        for (float num : arr) {
            int bucketIndex = (int) (num * numBuckets);  // 假设元素范围在[0, 1)之间
            buckets[bucketIndex].add(num);
        }

        // 对每个桶进行排序
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 合并所有桶中的元素
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }
}
