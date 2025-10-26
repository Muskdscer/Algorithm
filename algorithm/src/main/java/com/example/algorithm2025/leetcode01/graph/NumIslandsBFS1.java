package com.example.algorithm2025.leetcode01.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslandsBFS1 {
    class pair {
        int first;
        int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return ans;
    }

    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<NumIslandsBfs.pair> queue = new LinkedList<NumIslandsBfs.pair>();
        queue.add(new NumIslandsBfs.pair(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.peek().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                if (!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                    queue.add(new NumIslandsBfs.pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
