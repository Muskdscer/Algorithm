package com.example.algorithm.kamaCoder.hot100;

import java.util.Arrays;

public class LessArrowNum {
    public static void main(String[] args) {
        int[][] points = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        int sum = getResult(points);
    }

    private static int getResult(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int sum = 1;
        int[] temp = new int[2];
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int start = points[0][0];
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                sum++;
                start = points[i][0];
                end = points[i][1];
            } else {
                end = Math.min(points[i][1], end);//画图看一下 大于这个较小值才加一只箭
            }
        }
        return sum;
    }
}
