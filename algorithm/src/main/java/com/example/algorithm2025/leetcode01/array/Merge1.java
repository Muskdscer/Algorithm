package com.example.algorithm2025.leetcode01.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge1 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6},{8,10},{15,18}};
        int[][] results = merge(intervals);
        System.out.println("合并后的区间是：" + results);
    }

    private static  int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按左边界排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最大右边界
            if (intervals[i][0] > rightmostRightBound) {
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
