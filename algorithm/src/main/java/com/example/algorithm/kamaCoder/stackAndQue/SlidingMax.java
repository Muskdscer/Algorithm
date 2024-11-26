package com.example.algorithm.kamaCoder.stackAndQue;

import java.util.List;

public class SlidingMax {
    static int[] temp = new int[5];

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow1(arr, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] maxSlidingWindow1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;
        temp[0] = max;
        int left = 0;
        for (int right = k; right < arr.length - 1; right++) {
            sum += arr[right] - arr[left];
            max = Math.max(max, sum);
            temp[k - 2] = max;
            left++;
        }
        return temp;
    }
}
