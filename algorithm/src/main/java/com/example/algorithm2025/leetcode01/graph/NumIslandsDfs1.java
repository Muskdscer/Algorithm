package com.example.algorithm2025.leetcode01.graph;

public class NumIslandsDfs1 {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    visited[i][j] = true;
                    dfs(visited, i, j, grid);
                }
            }
        }
        return ans;
    }

    public static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private void dfs(boolean[][] visited, int i, int j, char[][] grid) {
        for (int k = 0; k < 4; k++) {
            int nextX = i + dirs[i][0];
            int nextY = j + dirs[i][j];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                continue;
            }
            if (!visited[i][j] && grid[i][j] == '1') {
                visited[i][j] = true;
                dfs(visited, nextX, nextY, grid);
            }
        }
    }
}
