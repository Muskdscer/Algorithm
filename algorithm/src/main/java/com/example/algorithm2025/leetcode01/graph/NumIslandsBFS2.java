package com.example.algorithm2025.leetcode01.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslandsBFS2 {
    class pair {
        int first;
        int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int numIslands (char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    visited[i][j] = true;
                    bfs(visited, i, j, grid);
                }
            }
        }
        return ans;
    }

    public static int[][] dirs = {{0 , 1}, {1, 0}, {-1, 0}, {0, -1}};
    private void bfs(boolean[][] visited, int i, int j, char[][] grid) {
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.poll().second;
            for (int k = 0; k < 4; k++) {
                int nextX = curX + dirs[i][0];
                int nextY = curY + dirs[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                if (!visited[i][j] && grid[i][j] == '1') {
                    queue.add(new pair(nextX, nextY));
                    visited[i][j] = true;
                }
            }
        }
    }
}
