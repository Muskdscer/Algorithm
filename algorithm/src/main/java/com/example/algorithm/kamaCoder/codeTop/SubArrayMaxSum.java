package com.example.algorithm.kamaCoder.codeTop;

public class SubArrayMaxSum {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = getSum(nums);
    }

    private static int getSum(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            if (sum > 0) {
                max = Math.max(sum, max);
            } else {
                sum = 0;
            }
        }
        return max;
    }
}
