package com.example.algorithm2025.leetCode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//广搜思路：到一个没有遍历过的节点陆地，计数器就加一，然后把该节点陆地所能遍历到的陆地都标记上。
//再遇到标记过的陆地节点和海洋节点的时候直接跳过
public class NoIslandBfs1 {
    static class pair {
        int first;
        int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//下右上左逆时针遍历

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[m][n] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        //定义队列
        Queue<pair> que = new LinkedList<pair>();
        que.add(new pair(x, y));
        while (!que.isEmpty()) {
            int curX = que.peek().first;
            int curY = que.poll().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                //去除边界部分
                if ((nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length)) {
                    continue;
                }
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    que.add(new pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
