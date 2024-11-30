package com.example.algorithm.kamaCoder.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] res = getResult(intervals);
    }

    private static int[][] getResult(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(intervals[i][1], end);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
