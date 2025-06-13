package com.example.algorithm2025.leetcode01.array;

public class FirstMissingPositive1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        int res = firstMissingPositive1(nums);
        System.out.println("确实的第一个正数： " + res);
    }
    private static int firstMissingPositive1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] < length && nums[nums[i] - 1] != nums[i]) {
                swap1(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i +1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    private static void swap1(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
