package com.example.algorithm2025.leetcode01.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFU {
    class Node {
        int key;
        int value;
        int freq = 1;
        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache; //存储缓存内容
    Map<Integer, LinkedHashSet<Node>> freqMap; //存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; //存储当前最小频次

    public LFU(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    private void freqInc(Node node) {
        //从原freq对应的链表里移除，并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        //加入新freq对应链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            newSet.add(node);
            freqMap.put(freq + 1, newSet);
        } else {
            newSet.add(node);
            freqMap.put(freq + 1, newSet);
        }
    }

    public void put (int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    private Node removeNode() {
        LinkedHashSet<Node> nodes = freqMap.get(min);
        Node deadNode = nodes.iterator().next();
        nodes.remove(deadNode);
        return deadNode;
    }

    private void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);//刚加进来的元素不用添加进set集合里面去？
        }
        set.add(node);
        min = 1;
    }
}
