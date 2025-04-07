package com.example.algorithm2025.leetCode.graph;

import java.util.Scanner;

public class SankIslandBfs {
    static int[][] dir = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} }; // 保存四个方向

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        } 
        
        //左侧边 右侧边
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][m - 1] == 1) dfs(grid, i, m - 1);
        }
        //上边  下边
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j);
            if (grid[n - 1][j] == 1) dfs(grid, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                }
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(grid[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void dfs(int[][] grid, int x , int y) {
        grid[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            if (grid[nextX][nextY] == 0 || grid[nextX][nextY] == 2) {
                continue;
            }
            dfs(grid, nextX, nextY);
        }
    }
}
