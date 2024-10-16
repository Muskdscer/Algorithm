package com.example.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Entry head, tail;
    int capacity;
    int size;
    Map<Integer, Entry> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //初始化链表
        initLinkedList();
        size = 0;
        cache = new HashMap<>(capacity + 2);
    }

    /**
     * 如果节点不存在 返回-1 如果存在，将节点移动到链表头部，并返回节点数据
     * @param key
     * @return
     */
    public int get(int key) {
        Entry node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 将节点加入到头节点，如果容量已满，会删除尾节点
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Entry node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        //不存在，先加进去，再移除尾节点
        //此时容量已满 删除尾节点
        if (size == capacity) {
            Entry lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }
        //加入头结点
        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key, newNode);
        size++;
    }

    private void moveToHead(Entry node){
        //首先删除原来节点关系
        deleteNode(node);
        addNode(node);
    }

    private void addNode(Entry node){
        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;
    }

    private void deleteNode(Entry node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public static class Entry {
        public Entry pre;
        public Entry next;
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }
    }

    private void initLinkedList(){
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}
