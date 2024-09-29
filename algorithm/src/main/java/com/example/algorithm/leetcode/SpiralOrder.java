package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startX = 0, startY = 0;
        List<Integer> res = new ArrayList<>();
        int offset = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int sumLoop = Math.min(m, n);
        int loop = 0;
        int i = 0, j = 0;
        while (loop < sumLoop / 2) {
            i = startX;
            j = startY;
            for (j = startY; j < n - offset; j++) {
                res.add(matrix[i][j]);
            }
            for (i = startX; i < m - offset; i++) {
                res.add(matrix[i][j]);
            }
            for (; j > startX; j--) {
                res.add(matrix[i][j]);
            }
            for (; i > startY; i--) {
                res.add(matrix[i][j]);
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }

        //处理剩余的单行或者单列
        if (sumLoop % 2 == 1 && sumLoop == m) {
            for (int k = startY; k < n - offset + 1; k++) {
                res.add(matrix[startX][k]);
            }
        } else if (sumLoop % 2 == 1 && sumLoop == n) {
            for (int k = startX; k < m - offset + 1; k++) {
                res.add(matrix[k][startY]);
            }
        }
        return res;
    }
}
