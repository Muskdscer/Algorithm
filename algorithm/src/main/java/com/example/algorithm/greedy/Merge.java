package com.example.algorithm.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //左边界从小到大排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > rightmostRightBound) {
                //加入区间 并且更新start
                res.add(new int[]{start, rightmostRightBound});
                start = intervals[i][0];
                rightmostRightBound = intervals[i][1];
            } else {
                //更新最大右边界
                rightmostRightBound = Math.max(rightmostRightBound, intervals[i][1]);
            }
        }
        res.add(new int[]{start, rightmostRightBound});
        return res.toArray(new int[res.size()][]);
    }
}
