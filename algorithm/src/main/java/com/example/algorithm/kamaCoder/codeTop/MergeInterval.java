package com.example.algorithm.kamaCoder.codeTop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        //按左边界排序
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int rightmostBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > rightmostBound) {
                //加入区间 更新start
                res.add(new int[]{start,rightmostBound});
                start = intervals[i][0];
                rightmostBound = intervals[i][1];
            } else {
                rightmostBound = Math.max(rightmostBound,intervals[i][1]);
            }
        }
        res.add(new int[]{start,rightmostBound});
        return res.toArray(new int[res.size()][]);
    }
}
