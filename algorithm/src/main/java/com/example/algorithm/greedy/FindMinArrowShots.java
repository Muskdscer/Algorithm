package com.example.algorithm.greedy;

import java.util.Arrays;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);//i右边界缩短到和i-1一齐 作为下一个i的i-1参与运算
            }
        }
        return count;
    }
}
