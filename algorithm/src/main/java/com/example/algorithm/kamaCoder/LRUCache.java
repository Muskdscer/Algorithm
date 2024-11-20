package com.example.algorithm.kamaCoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 其实LinkedHashMap已经实现了LRU缓存淘汰算法
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {
    private int capacity;

    private Map<K, LRUNode> map;

    private LRUNode head;

    private LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<K, LRUNode>();
    }

    public synchronized void put(K k, V v) {
        LRUNode node = map.get(k);
        //存在该key, 将节点设置为head
        if (node != null) {
            node.value = v;

            remove(node, false);
        } else {
            /**
             * 该节点不存在
             * 1.将该节点接入缓存
             * 2.设置该节点为head
             * 3.判断是否超出容量，超出则删除尾节点
             */
            node = new LRUNode(k, v);

            if (map.size() >= capacity) {
                //删除tail节点
                remove(tail, true);
            }
            map.put(k, node);
            setHead(node);
        }

        //设置当前节点为首节点
        setHead(node);
    }

    public  Object get(String key) {
        LRUNode node = map.get(key);
        if (node != null) {
            //将刚操作的元素放到head
            remove(node, false);
            setHead(node);
            return node.value;
        }
        return null;
    }

    /**
     * 设置头结点
     * @param node
     */
    private void setHead(LRUNode node) {
        if (head != null) {
            if (node != null) {
                node.next = head;
                head.prev = node;
            }
            head = node;
            if (tail == null){
                tail = node;
            }
        }
    }

    /**
     * 从链表中删除此Node
     * @param node
     * @param flag 为true就删除此节点的key
     */
    private void remove(LRUNode node, boolean flag) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        node.next = null;
        node.prev = null;
        if (flag) {
            map.remove(node.key);
        }
    }

    private Iterator iterator() {
        return map.keySet().iterator();
    }

    private class LRUNode<K, V> {
        /**
         * cache的key
         */
        private  K key;

        /**
         * cache的value
         */
        private V value;

        private LRUNode prev;

        private LRUNode next;

        public LRUNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


}
