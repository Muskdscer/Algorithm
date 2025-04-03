package com.example.algorithm2025.leetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 邻接表
 */
public class Dfs3 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        //节点编号从1到n 所以申请n + 1 这么大数组
        List<LinkedList<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        while (m-- > 0) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            //使用邻接表表示 s -> t是相连的
            graph.get(s).add(t);
        }
        path.add(1);//无论什么路径都是从1出发
        dfs(graph, 1, n);//开始遍历
        
    }

    public static void dfs(List<LinkedList<Integer>> graph, int x, int n) {
        if (x == n) {
            //找到符合条件的一条路径
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : graph.get(x)) {
            //找到x指向的节点
            //遍历到的节点加入到路径中来
            path.add(i);
            //进入下一层递归
            dfs(graph, i, n);
            //回溯撤销本节点
            path.remove(path.size() - 1);
        }
    }
}
