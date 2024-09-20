package com.example.algorithm.array;

public class Search {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int index = search(arr, target);
        System.out.println(index);
    }

    private static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
