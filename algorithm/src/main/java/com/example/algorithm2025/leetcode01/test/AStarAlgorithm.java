package com.example.algorithm2025.leetcode01.test;

import java.util.*;

public class AStarAlgorithm {
    // 网格的行数和列数
    private static int rows;
    private static int cols;
    // 障碍物标记（true为障碍物）
    private static boolean[][] obstacles;
    // 方向数组：上下左右4个方向（可扩展为8方向）
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 计算曼哈顿距离（4方向移动）
    private static int calculateH(Node node, Node goal) {
        return Math.abs(node.x - goal.x) + Math.abs(node.y - goal.y);
    }

    // A*寻路核心逻辑
    public static List<Node> aStarSearch(Node start, Node goal, boolean[][] gridObstacles) {
        rows = gridObstacles.length;
        cols = gridObstacles[0].length;
        obstacles = gridObstacles;

        // 开放列表（优先队列）和关闭列表（HashSet）
        PriorityQueue<Node> openList = new PriorityQueue<>();
        Set<Node> closedList = new HashSet<>();

        // 初始化起点
        openList.add(start);
        while (!openList.isEmpty()) {
            // 取出f值最小的节点
            Node current = openList.poll();

            // 到达终点，回溯路径
            if (current.equals(goal)) {
                return buildPath(current);
            }

            closedList.add(current);
            // 遍历所有相邻节点
            for (int[] dir : dirs) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                // 检查边界和障碍物
                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || obstacles[newX][newY]) {
                    continue;
                }

                Node neighbor = new Node(newX, newY);
                // 若已在关闭列表，跳过
                if (closedList.contains(neighbor)) {
                    continue;
                }

                // 计算临时g值（相邻节点移动代价为1）
                int tempG = current.g + 1;

                // 若邻居不在开放列表，或新路径更优
                boolean isNewNode = !openList.contains(neighbor);
                if (isNewNode || tempG < neighbor.g) {
                    neighbor.g = tempG;
                    neighbor.h = calculateH(neighbor, goal);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;

                    if (isNewNode) {
                        openList.add(neighbor);
                    } else {
                        // 若已存在，更新优先队列（Java优先队列需手动移除旧节点再添加）
                        openList.remove(neighbor);
                        openList.add(neighbor);
                    }
                }
            }
        }
        // 无可行路径
        return Collections.emptyList();
    }

    // 回溯构建路径
    private static List<Node> buildPath(Node goal) {
        List<Node> path = new ArrayList<>();
        Node current = goal;
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        // 反转路径，从起点到终点
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // 构建网格：true为障碍物，false为可通行
        boolean[][] obstacles = {
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, true, false},
                {false, true, false, false, false},
                {false, false, false, false, false}
        };

        // 起点(0,0)，终点(4,4)
        Node start = new Node(0, 0);
        Node goal = new Node(4, 4);

        List<Node> path = aStarSearch(start, goal, obstacles);

        if (path.isEmpty()) {
            System.out.println("无可行路径");
        } else {
            System.out.println("最短路径（坐标x,y）：");
            for (Node node : path) {
                System.out.printf("(%d,%d) ", node.x, node.y);
            }
        }
    }
}
