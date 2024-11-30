package com.example.algorithm.kamaCoder.hot100;

import java.util.Arrays;

public class EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {2,3}, {3,4}, {1,3}};
        int count = getNum(intervals);
    }

    //按照左边界排序
    private static int getNum(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int removeNum = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                removeNum++;
                end = Math.min(intervals[i][1], end);
            }
        }
        return removeNum;
    }
}
