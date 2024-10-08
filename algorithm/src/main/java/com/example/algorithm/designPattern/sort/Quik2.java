package com.example.algorithm.designPattern.sort;

import java.util.Arrays;

public class Quik2 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,3,6,4};
        System.out.println("原始数组："+ Arrays.toString(arr));
        quickSort2(arr,0,arr.length - 1);
        System.out.println("排序后的数组："+ Arrays.toString(arr));
    }
    public static void quickSort2(int[] arr, int low, int high)
    {
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort2(arr, low, j-1);
        //递归调用右半数组
        quickSort2(arr, j+1, high);
    }
}
