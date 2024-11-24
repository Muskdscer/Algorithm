package com.example.algorithm.kamaCoder.codeTop;

import com.example.algorithm.kamaCoder.HashMapDemo;

public class MyHashMapDemo<K, V> {
    public static void main(String[] args) {

    }

    static class Node<K, V>{
        K key;
        V value;
        Node next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int CAPACITY = 16;
    private Node[] nodes = new Node[CAPACITY];

    public MyHashMapDemo() {
    }

    public void put(K key, V v) {
        Node<K, V> kvNode = new Node<>(key, v);
        int idx = getIndex(key);
        Node node = nodes[idx];
        if (node == null) {
            nodes[idx] = kvNode;
        } else {
            while (node.next != null) {
                if (node.key == key) {
                    node.value = v;
                    return;
                }
                node = node.next;
            }
            if (node.key.equals(key)) {
                node.value = v;
            } else {
                node.next = kvNode;
            }
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        return Math.abs(hash) % CAPACITY;
    }

}
