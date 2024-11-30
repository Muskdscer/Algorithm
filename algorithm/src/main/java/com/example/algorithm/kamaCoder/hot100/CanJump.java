package com.example.algorithm.kamaCoder.hot100;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
