package com.example.algorithm.kamaCoder.hot100;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums =  new int[]{3,2,1,5,6,4};
        int result = findKthLargest(nums, 3);
    }

    private static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int res = getKth(nums, k);
        return res;
    }

    private static int getKth(int[] nums, int k) {
        //第一次调整
        for (int i = nums.length / 2 - 1;  i >= 0; i--) {
            Adjust(nums, i, nums.length - 1);
        }

        for (int i = nums.length - 1; i > nums.length - k ; i--) {
            swap111(nums, 0, i);
            Adjust(nums, 0, i);
        }
        return nums[0];
    }

    private static void swap111(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }

    private static void Adjust(int[] nums, int start, int end) {
        int temp = nums[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if (i < end && nums[i] < nums[i + 1]) {
                i++;
            }

            if (nums[start] < nums[i]) {
                nums[start] = nums[i];
                start = i;
            } else {
                break;
            }
        }
        nums[start] = temp;
    }
}
