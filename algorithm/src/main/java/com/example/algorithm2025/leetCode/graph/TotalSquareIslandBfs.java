package com.example.algorithm2025.leetCode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TotalSquareIslandBfs {
    private static int count = 0;
    private static final int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 四个方向

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];

        // 读取网格
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        //左侧边 右侧边
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                bfs(grid, i, 0);
            }
            if (grid[i][m - 1] == 1) {
                bfs(grid, i, m - 1);
            }
        }

        //上边 下边
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                bfs(grid, 0, i);
            }
            if (grid[n - 1][i] == 1) {
                bfs(grid, n - 1, i);
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);
                }
            }
        }
    }

    private static void bfs(int[][] grid, int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        grid[x][y] = 0;
        count++;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                if (grid[nextX][nextY] == 1) {
                    que.add(new int[]{nextX, nextY});
                    count++;
                    grid[nextX][nextY] = 0;
                }
            }
        }
    }
}
