package com.example.algorithm2025.leetCode.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SquareIslandBfs {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int result = 0;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    bfs(map, visited, i, j);
                    result = Math.max(count, result);
                }
            }
        }
    }

    private static void bfs(int[][] map, boolean[][] visited, int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x,y));
        visited[x][y] = true;
        count++;
        while (!que.isEmpty()) {
            Node node = que.remove();
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dir[i][0];
                int nextY = node.y + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length || visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }
                que.add(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
                count++;
            }
        }
    }
}
