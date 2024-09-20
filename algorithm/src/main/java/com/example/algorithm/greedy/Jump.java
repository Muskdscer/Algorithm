package com.example.algorithm.greedy;

public class Jump {
    public int jump(int[] nums) {
        if (nums ==  null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        //记录跳跃次数
        int count = 0;
        //当前覆盖的最大区域
        int curCoverRange = 0;
        //最大的覆盖区域
        int maxCoverRange = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCoverRange = Math.max(maxCoverRange, i + nums[i]);
            if (maxCoverRange >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curCoverRange){
                curCoverRange = maxCoverRange;
                count++;
            }
        }
        return count;
    }
}
