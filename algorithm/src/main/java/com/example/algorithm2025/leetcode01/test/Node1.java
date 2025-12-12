package com.example.algorithm2025.leetcode01.test;

import java.util.Comparator;
import java.util.Objects;

//网络节点类
public class Node1 implements Comparable<Node1>{
    int x, y;          // 节点坐标
    int g;             // 起点到当前节点的实际代价
    int h;             // 到终点的预估代价
    int f;             // 总代价 f = g + h
    Node1 parent;       // 父节点，用于回溯路径

    @Override
    public int compareTo(Node1 o) {
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
        Node1 node = (Node1) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
