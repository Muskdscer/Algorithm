package com.example.algorithm.array;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;
        int offset = 1;
        int count = 1;//矩阵中需要填写的数字
        int loop = 1;//记录当前的圈数
        int i,j;//j代表 列，i代表行
        while(loop <= n / 2) {
            //顶部 左闭右开
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            //右侧 上闭下开
            for (i = 0; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            //底部 左闭右开
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }
            //左侧 上闭下开
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            //第二圈开始的时候。起始位置各自加1
            startX++;
            startY++;
            //offset控制每一圈里每一条边的遍历长度
            offset += 1;
        }

        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
}
