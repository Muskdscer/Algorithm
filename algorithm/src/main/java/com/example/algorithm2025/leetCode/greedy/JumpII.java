package com.example.algorithm2025.leetCode.greedy;

public class JumpII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃次数
        int count = 0;
        //当前的覆盖最大范围
        int curDistance = 0;
        //最大覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步 再跳一步就达到了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            //走到单亲啊覆盖区域最大区域时 更新下一步就可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
