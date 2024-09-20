package com.example.algorithm.designPattern.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,3,6,4};
        System.out.println("原始数组："+ Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后的数组："+ Arrays.toString(arr));
    }

    public static void heapSort(int[] arr)
    {
        //第一次建立大根堆，从后往前依次调整
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            HeapAdjust(arr, i, arr.length);
        }
        //调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0 ; j--) {
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            HeapAdjust(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 交换数组中两个元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 调整大顶堆(仅仅是调整过程，建立在大顶堆已经构建的基础上)
     * @param arr
     * @param start
     * @param end
     */
    public static void HeapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];//先取出当前元素i
        for (int i = 2 * start + 1; i <= end; i = i * 2 + 1) {//从i节点的左子节点开始，也就是2i + 1处开始
            if (i < end && arr[i] < arr[i + 1]) {//有右孩子并且左孩子小于右孩子  如果左子节点小于右子节点 i指向右子节点
                i++;
            }
            //i一定是左右孩子最大值  如果子节点大于父节点，将将子节点赋值给父节点(不用进行交换)
            if (arr[i] > temp) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;//将temp值放到最终位置
    }
}
