package com.example.algorithm.greedy;

public class MaxSubArrayDemo {
    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }

    /**
     * 动规
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + nums[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
