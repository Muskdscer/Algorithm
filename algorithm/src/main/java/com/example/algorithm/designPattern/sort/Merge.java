package com.example.algorithm.designPattern.sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int[] add=new int[arr.length];
        System.out.println("排序前:"+Arrays.toString(arr));
        System.out.println("排序过程: ");
        mergeSort(arr,0,arr.length-1,add);
        System.out.println("排序后:"+Arrays.toString(arr));
    }

    /**
     * 分
     * @param arr  排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param right  右边索引
     * @param temp  做中转的数组
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp)
    {
        //求中间索引
        int mid = (left + right) / 2;

        if (left < right)
        {
            //左边递归分解
            mergeSort(arr,left,mid,temp);

            //右边递归分解
            mergeSort(arr,mid+1,right,temp);

            System.out.println(" 最左边索引:"+left+"\t最右边边索引:"+right+"\t"+ Arrays.toString(arr));
        }
    }

    /**
     *
     * @param arr  排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid  中间索引
     * @param right  右边索引
     * @param temp  做中转的数组
     */
    // 4 5 7 8  1 2 6 3
    public static void merge(int[] arr,int left,int mid,int right,int[] temp)
    {
        int i = left;  //初始i, 左边有序序列的初始索引
        int j = mid+1;  //初始j，右边有序序列的初始索引
        int t = 0;  //指向temp数组的当前索引

        //1.
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right)
        {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
            //因为无论执行if里面的语句还是else里面的语句，t都要加1，所以把t拿出来
            t++;
        }

        //2.
        //把有剩余的数据一边的数据依次全部填充到temp
        //由此要么i>mid 要么j>right
        while (i <= mid)
        {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right)
        {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3.
        //把temp的数组转移到arr上
        int n = 0;
        int tempLeft = left;
        while (tempLeft <= right)
        {
            arr[tempLeft] = temp[n];
            n++;
            tempLeft++;
        }
    }
}
