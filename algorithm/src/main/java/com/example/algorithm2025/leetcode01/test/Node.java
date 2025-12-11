package com.example.algorithm2025.leetcode01.test;

import java.util.Objects;

//网络节点类
public class Node implements Comparable<Node>{
    int x, y;          // 节点坐标
    int g;             // 起点到当前节点的实际代价
    int h;             // 到终点的预估代价
    int f;             // 总代价 f = g + h
    Node parent;       // 父节点，用于回溯路径

    // 优先队列按f值升序排序，f相同则按h值升序
    @Override
    public int compareTo(Node o) {
        if (this.f != o.f) {
            return Integer.compare(this.f, o.f);
        }
        return Integer.compare(this.h, o.h);
    }

    // 重写equals和hashCode，用于判断节点是否重复
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
