package com.example.algorithm2025.leetcode01.greedy;

import java.util.Arrays;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        //直径左边界从小到大排列
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            //i和i-1 不挨着
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                //更新最小右边界
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
