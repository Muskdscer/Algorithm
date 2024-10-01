package com.example.algorithm.greedy;

public class jump2 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        //记录跳跃次数
        int count = 0;
        //当前最大覆盖范围
        int curDistance = 0;
        //最大覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }

            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
