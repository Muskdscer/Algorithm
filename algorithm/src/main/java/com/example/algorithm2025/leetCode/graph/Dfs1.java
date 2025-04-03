package com.example.algorithm2025.leetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 邻接表写法
 */
public class Dfs1 {
    static List<List<Integer>> result = new ArrayList<>(); // 收集符合条件的路径
    static List<Integer> path = new ArrayList<>(); // 1节点到终点的路径

    public static void dfs(List<LinkedList<Integer>> graph, int x, int n) {
        if (x == n) { // 找到符合条件的一条路径
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph.get(x)) { // 找到 x指向的节点
            path.add(i); // 遍历到的节点加入到路径中来
            dfs(graph, i, n); // 进入下一层递归
            path.remove(path.size() - 1); // 回溯，撤销本节点
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 节点编号从1到n，所以申请 n+1 这么大的数组
        List<LinkedList<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        while (m-- > 0) {
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            // 使用邻接表表示 s -> t 是相连的
            graph.get(s).add(t);
        }

        path.add(1); // 无论什么路径已经是从1节点出发
        dfs(graph, 1, n); // 开始遍历

        // 输出结果
        if (result.isEmpty()) System.out.println(-1);
        for (List<Integer> pa : result) {
            for (int i = 0; i < pa.size() - 1; i++) {
                System.out.print(pa.get(i) + " ");
            }
            System.out.println(pa.get(pa.size() - 1));
        }
    }
}
