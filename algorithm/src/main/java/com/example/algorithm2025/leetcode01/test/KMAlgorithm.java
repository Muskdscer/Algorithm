package com.example.algorithm2025.leetcode01.test;

import java.util.Arrays;

//DFS 实现，适用于小规模二分图
public class KMAlgorithm {
    private static int n; // 二分图两边的顶点数（左X，右Y，数量均为n）
    private static int[][] w; // 权值矩阵，w[u][v]表示左u到右v的边权
    private static int[] lx; // 左顶点顶标
    private static int[] ly; // 右顶点顶标
    private static boolean[] visX; // 标记左顶点是否被访问（DFS时）
    private static boolean[] visY; // 标记右顶点是否被访问（DFS时）
    private static int[] matchY; // 右顶点匹配的左顶点（matchY[v]=u表示v匹配到u）
    private static int[] slack; // 松弛数组，slack[v] = min(lx[u]+ly[v]-w[u][v])（u∈已访问，v∈未访问）

    // KM算法核心：求解最大权完美匹配，返回最大权值和
    public static int km() {
        // 初始化顶标
        lx = new int[n];
        ly = new int[n];
        matchY = new int[n];
        Arrays.fill(matchY, -1); // 初始时右顶点未匹配

        // 左顶点顶标初始化：取该顶点的最大边权
        for (int u = 0; u < n; u++) {
            lx[u] = Arrays.stream(w[u]).max().getAsInt();
        }

        // 为每个左顶点寻找增广路
        for (int u = 0; u < n; u++) {
            slack = new int[n];
            Arrays.fill(slack, Integer.MAX_VALUE); // 松弛数组初始化
            while (true) {
                visX = new boolean[n];
                visY = new boolean[n];
                // DFS寻找增广路，若找到则退出循环
                if (dfs(u)) {
                    break;
                }
                // 未找到，调整顶标：计算松弛量d
                int d = Integer.MAX_VALUE;
                for (int v = 0; v < n; v++) {
                    if (!visY[v] && slack[v] < d) {
                        d = slack[v];
                    }
                }
                // 更新左顶点顶标（已访问的减d）
                for (int i = 0; i < n; i++) {
                    if (visX[i]) {
                        lx[i] -= d;
                    }
                }
                // 更新右顶点顶标（已访问的加d）
                for (int v = 0; v < n; v++) {
                    if (visY[v]) {
                        ly[v] += d;
                    } else {
                        // 松弛量更新（未访问的右顶点slack减d）
                        slack[v] -= d;
                    }
                }
            }
        }

        // 计算最大权值和
        int maxWeight = 0;
        for (int v = 0; v < n; v++) {
            if (matchY[v] != -1) {
                maxWeight += w[matchY[v]][v];
            }
        }
        return maxWeight;
    }

    // DFS：判断左顶点u能否在相等子图中找到增广路
    private static boolean dfs(int u) {
        visX[u] = true;
        for (int v = 0; v < n; v++) {
            if (!visY[v]) {
                int temp = lx[u] + ly[v] - w[u][v];
                if (temp == 0) { // 边(u,v)在相等子图中
                    visY[v] = true;
                    // 若v未匹配，或v的匹配顶点能找到新的增广路
                    if (matchY[v] == -1 || dfs(matchY[v])) {
                        matchY[v] = u;
                        return true;
                    }
                } else {
                    // 更新松弛量：保留最小的temp
                    slack[v] = Math.min(slack[v], temp);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 示例：3个工人（左0,1,2）分配到3个任务（右0,1,2），权值为效率
        n = 3;
        w = new int[][]{
                {3, 5, 5},
                {4, 4, 3},
                {5, 2, 2}
        };

        int maxWeight = km();
        System.out.println("最大权完美匹配的权值和：" + maxWeight);

        // 输出匹配结果（左顶点→右顶点）
        System.out.println("匹配方案：");
        for (int v = 0; v < n; v++) {
            System.out.printf("左顶点%d → 右顶点%d（权值：%d）\n", matchY[v], v, w[matchY[v]][v]);
        }
    }
}
