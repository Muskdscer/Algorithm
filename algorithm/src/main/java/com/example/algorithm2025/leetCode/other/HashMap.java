package com.example.algorithm2025.leetCode.other;

import com.example.algorithm.kamaCoder.HashMapDemo;

public class HashMap {
    public static void main(String[] args) {
        HashMap hashMapDemo = new HashMap();
        hashMapDemo.put(1, 1);
        hashMapDemo.put(2, 2);
        System.out.println(hashMapDemo.get(1));
        hashMapDemo.put(3, 3);
        System.out.println(hashMapDemo.get(2));
    }

    static class Node {
        int key, value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int CAPACITY = 16;
    //hash桶位置
    Node[] nodes = new Node[CAPACITY];

    public void put(int key, int value) {
        int idx = getIndex(key);
        Node now = nodes[idx], temp = now;
        if (temp != null) {
            Node prev = null;
            while (temp != null) {
                if (temp.key == key) {
                    now.value = value;
                    return;
                }
                prev = temp;//prev值不会因为下面temp值改变而改变 temp后赋值的prev不变 简单小demo实现一下验证
                temp = temp.next;
            }
            temp = prev;
        }

        Node node = new Node(key, value);
        if (temp != null) {
            temp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public int get(int key) {
        int idx = getIndex(key);
        Node now = nodes[idx];

        if (now != null) {
            if (now.key == key) {
                return now.value;
            } else {
                while (now != null) {
                    if (now.key == key) {
                        return now.value;
                    }
                    now = now.next;
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getIndex(key);
        Node now = nodes[idx];

        if (now != null) {
            Node prev = null;
            while (now != null) {
                if (now.key == key) {
                    if (prev != null) {
                        prev.next = now.next;
                    } else {
                        nodes[idx] = now.next;
                    }
                    now.next = null;
                    return;
                }
                prev = now;
                now = now.next;
            }
        }
    }

    private int getIndex(int key){
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % CAPACITY;
    }
}
