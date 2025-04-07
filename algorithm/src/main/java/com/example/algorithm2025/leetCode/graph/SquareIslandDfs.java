package com.example.algorithm2025.leetCode.graph;

import java.util.Scanner;

public class SquareIslandDfs {
    static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int result=0;
    static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(map, visited, i, j);
                    result = Math.max(count, result);
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        count++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length || visited[nextX][nextY] || map[nextX][nextY] == 0) {
                continue;
            }
            dfs(map, visited, nextX, nextY);
        }
    }
}
