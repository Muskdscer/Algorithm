package com.example.algorithm.kamaCoder.other;

import com.example.algorithm.kamaCoder.HashMapDemo;

public class MyHashMap {
    public static void main(String[] args) {

    }

    static class HashDemo {
        class Node {
            int key, val;
            Node next;;
            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private final int CAPACITY = 16;
        Node[] nodes = new Node[CAPACITY];

        public void put(int key, int value) {
            int idx = getIndex(key);
            Node now = nodes[idx], temp = now;
            if (temp != null) {
                Node prev = null;
                while (temp != null) {
                    if (temp.key == key) {
                        temp.val = value;
                        return;
                    }
                    prev = temp;
                }
            }
        }

        public int get(int key) {
            int idx = getIndex(key);
            Node now = nodes[idx];
            if (now != null) {
                if (now.key == key) {
                    return now.val;
                } else {
                    while (now != null) {
                        if (now.key == key) {
                            return now.val;
                        }
                        now = now.next;
                    }
                }
            }
            return -1;
        }

        public void  remove(int key) {
            int idx = getIndex(key);
            Node now = nodes[idx];

            if (now != null) {
                Node prev = null;
                while (now != null) {
                    if (now.key == key) {
                        if (prev != null) {
                            prev.next = now.next;
                        }else {
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

        private int getIndex(int key) {
            int hash = Integer.hashCode(key);
            hash ^= (hash >>> 16);
            return hash % CAPACITY;
        }
    }
}
