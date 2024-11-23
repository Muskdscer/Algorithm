package com.example.algorithm.kamaCoder.other;

import com.example.algorithm.kamaCoder.LRUCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//头和尾是 head和tail 不是null
public class LRU {
    static class LRUCache<K, V> {
        private int capacity;
        private Map<K, LRUNode> map;
        private LRUNode head;
        private LRUNode tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<K, LRUNode>();
        }

        //节点
        private class LRUNode {
            private K key;
            private V value;

            private LRUNode prev;
            private LRUNode next;
            public LRUNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        //put方法
        public synchronized void put(K k, V v) {
            LRUNode lruCache = map.get(k);
            //存在 将节点设置为head
            if (lruCache != null) {
                lruCache.value = v;
                remove(lruCache, false);
            } else {
                //不存在 加入缓存 设为head 判断是否超出容量 超出删除尾节点
                lruCache = new LRUNode(k, v);
                if (map.size() >= capacity) {
                    //删除tail节点
                    remove(tail, true);
                }
                map.put(k, lruCache);
                setHead(lruCache);
            }
            //设置当前节点为首节点
            setHead(lruCache);
        }

        //get方法
        public Object get(String key) {
            LRUNode lruNode = map.get(key);
            if (lruNode != null) {
                //操作的元素放到head
                remove(lruNode, false);
                setHead(lruNode);
                return lruNode.value;
            }
            return null;
        }

        private void setHead(LRUNode node) {
            if (head != null) {
                if (node != null) {
                    node.next = head;
                    head.prev = node;
                }
                head = node;
                if (tail == null) {
                    tail = node;
                }
            }
        }

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

        private Iterator iter() {
            return map.keySet().iterator();
        }
    }
}
