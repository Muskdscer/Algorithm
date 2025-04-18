package com.example.algorithm2025.leetCode.greedy;

import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围 初始覆盖范围应该是0 因为下面的迭代都是从下标0开始
        int coverRange = 0;
        //在覆盖范围内更新最大覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
