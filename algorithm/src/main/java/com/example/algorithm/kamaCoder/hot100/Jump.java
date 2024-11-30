package com.example.algorithm.kamaCoder.hot100;

public class Jump {
    //最小步数增加覆盖范围
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int count = 0;
        //当前的覆盖最大区域
        int curDistance = 0;
        int cover = 0;
        for (int i = 0; i < nums.length; i++) {
            cover = Math.max(i + nums[i], cover);

            //说明当前一步，再跳一步到达末尾，已经覆盖到了，还没跳而已
            if (cover >= nums.length - 1) {
                count++;
                break;
            }

            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = cover;
                count++;
            }
        }
        return count;
    }
}
