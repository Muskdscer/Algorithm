package com.example.algorithm.kamaCoder.hot100;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CanPartition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean flag = canConbine(nums);
    }

    private static boolean canConbine(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[] dp = new int[target];
        Arrays.fill(dp, 0);

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j++) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
            if(dp[target] == target)
                return true;
        }
        return dp[target] == target;
    }
}
