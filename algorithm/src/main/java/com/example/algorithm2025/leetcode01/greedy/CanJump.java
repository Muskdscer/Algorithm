package com.example.algorithm2025.leetcode01.greedy;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length ==1) {
            return true;
        }
        int coverRange = 0;
        //在覆盖的范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
