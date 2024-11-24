package com.example.algorithm.kamaCoder.codeTop;

import com.example.algorithm.kamaCoder.LRUCache;

import java.lang.*;
import java.util.*;
import java.io.*;

public class LRU<K,V> {
    public static void main(String[] args) {

    }

    static class Node<K,V> {
        K key;
        V v;
        Node pre;
        Node next;
        public Node(K key, V value) {
            this.key = key;
            this.v = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<K, Node> map;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public synchronized void put(K key, V value) {
        //Node node = new Node(key, value);
        Node node = map.get(key);
        if (node != null) {
            node.v = value;
            removeNode(node, false);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                removeNode(tail, true);
            }
            map.put(key, newNode);
            setHead(newNode);
        }
        setHead(node);
    }

    public Object get(K key) {
        Node node = map.get(key);
        if (node != null) {
            removeNode(node, false);
            setHead(node);
            return node.v;
        }
        return null;
    }

    private Iterator iterator() {
        return map.keySet().iterator();
    }

    private void setHead(Node newNode) {
        if (head != null) {
            if (newNode != null) {
                newNode.next = head;
                head = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        }
    }

    private void removeNode(Node node, boolean flag) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }

        node.next = null;
        node.pre = null;
        if (flag) {
            map.remove(node.key);
        }
    }
}
