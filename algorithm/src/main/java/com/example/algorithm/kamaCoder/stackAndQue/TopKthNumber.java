package com.example.algorithm.kamaCoder.stackAndQue;

public class TopKthNumber {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int result = findKthLargest(nums, 2);
        System.out.println(result);
    }

    //大顶堆
    private static int findKthLargest(int[] nums, int k) {
        //第一次调整大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i++) {
            AdjustNew(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i > nums.length - k + 1; i++) {
            swapNew1(nums, 0, i);
            AdjustNew(nums, 0, i);
        }
        return nums[0];
    }

    private static void swapNew1(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void AdjustNew(int[] nums, int start, int end) {
        int temp = nums[start];
        for (int i = 2 * start +1; i <= end; i = i * 2 +1) {
            if (i < end && nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[i] > temp) {
                nums[start] = nums[i];
                start = i;
            } else {
                break;
            }
        }
        nums[start] = temp;
    }
}
