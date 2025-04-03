package com.example.algorithm2025.leetCode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NoIslandBfs {
    static class pair {
        int first;
        int second;
        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static int[][] dir = {{0, 1}, {1,0},{0,-1},{-1,0}};//下右上左逆时针遍历

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
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
        //定义坐标队列，没右现成的pair类 在下面自定义了
        Queue<pair> queue = new LinkedList<pair>();
        queue.add(new pair(x, y));
        //遇到入列直接标记为优先
        //否则出队列时才标记的话会导致重复访问，比如下方节点会在右下顺序的时候被第二次访问入列
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.peek().second;//当前纵坐标
            for (int i = 0; i < 4; i++) {
                //顺时针遍历新节点next,下面记录坐标
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                //去除边界部分
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.add(new pair(nextX, nextY));
                    visited[nextX][nextY] = true;//逻辑同上
                }
            }
        }
    }
}
