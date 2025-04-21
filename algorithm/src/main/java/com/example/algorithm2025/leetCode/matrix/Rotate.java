package com.example.algorithm2025.leetCode.matrix;

public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //第一步 转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {//遍历对角线下方元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //第二步 行翻转
        for (int[] row : matrix) {
            for (int i = 0; i < n / 2; i++) {//遍历左半元素
                int temp = row[i];
                row[i] = row[n - 1 - i];
                row[n - 1 - i] = temp;
            }
        }
    }
}
