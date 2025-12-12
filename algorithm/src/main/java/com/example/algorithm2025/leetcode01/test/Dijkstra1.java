package com.example.algorithm2025.leetcode01.test;

import java.util.*;

public class Dijkstra1 {
    //求解源点start到所有顶点的最短距离，n为顶点总数，adj为邻接表
    public static int[] dijkstra(int n, List<List<Edge>> adj, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        //优先级队列，按距离升序排列，存储(当前距离，顶点)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curDist = cur[0];
            int u = cur[1];

            //若当前距离大于已知最短距离，跳过(旧的无效数据)
            if (curDist > dist[u]) {
                continue;
            }

            //遍历u的所有邻接边
            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                int weight = edge.weight;
                //松弛操作，更新最短距离
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 5;//顶点0-4
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        //构建图(无向边，双向添加)
        adj.get(0).add(new Edge(1, 2));
        adj.get(1).add(new Edge(0, 2));
        adj.get(0).add(new Edge(3, 5));
        adj.get(3).add(new Edge(0, 5));
        adj.get(1).add(new Edge(2, 3));
        adj.get(2).add(new Edge(1, 3));
        adj.get(1).add(new Edge(3, 1));
        adj.get(3).add(new Edge(1, 1));
        adj.get(2).add(new Edge(4, 2));
        adj.get(4).add(new Edge(2, 2));
        adj.get(3).add(new Edge(4, 4));
        adj.get(4).add(new Edge(3, 4));

        int start = 0;
        int[] shortestDist = dijkstra(n, adj, start);
        System.out.println("源点" + start + "到各顶点的最短距离：");
        for (int i = 0; i < n; i++) {
            System.out.println("到顶点" + i + "：" + (shortestDist[i] == Integer.MAX_VALUE ? "不可达" : shortestDist[i]));
        }
    }
}
