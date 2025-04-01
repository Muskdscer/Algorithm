package com.example.algorithm2025.leetCode.array;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] result = productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println("新数组元素： " + result[i]);
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        int[] ans = new int[len];
        ans[0] = 1;
        int temp = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0 ; i--) {
            temp *= nums[i + 1];
            ans[i] *= temp;
        }
        return ans;
    }

}
