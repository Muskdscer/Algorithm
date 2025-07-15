package com.example.algorithm2025.leetCode.other;

import com.example.algorithm2025.leetcode01.linkedlist.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    //定义节点
    public static class Entry {
        Entry pre;
        Entry next;
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Entry() {
        }
    }


    Entry head;
    Entry tail;
    int capacity;
    int size;
    //cache的key和Entry里的key一样
    Map<Integer, Entry> cache;

    public LRU(int capacity) {
        this.capacity = capacity;
        //初始化链表
        initLinkedList();
        this.size = 0;
        cache = new HashMap<>(capacity + 2);
    }

    private void initLinkedList(){
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 如果节点不存在返回-1，如果存在，将节点移动到链表头部，并返回节点数据
     * @param key
     * @return
     */
    public int get(int key) {
        Entry node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Entry node) {
        //删除掉原来节点关系
        deleteNode(node);
        //加上新的节点关系
        addNode(node);
    }

    private void deleteNode(Entry node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNode(Entry node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
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
        //不存在，先加进去再移除尾节点
        //此时容量已满移除尾节点
        if (size == capacity) {
            Entry lastNode = tail.pre;
            //移除lastNode节点关系
            deleteNode(lastNode);
            //cache的key和Entry的key一样
            cache.remove(lastNode.key);
            size--;
        }
        //加入头节点
        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        //cache的key和Entry的key一样
        cache.put(key, newNode);
        size++;
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }

}
