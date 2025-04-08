package com.example.algorithm2025.leetCode.graph;

public class Trie1 {
    private boolean isEnd;//该节点是否是一个串的结束
    private Trie1[] next;

    public Trie1() {
        isEnd  = false;
        next = new Trie1[26];
    }

    public void insert(String word) {
        Trie1 node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie1();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String prefix) {
        Trie1 node = this;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] != null) {
                node = node.next[c - 'a'];
            } else {
                 return false;
            }
        }
        return node.isEnd;
    }

    public boolean startWith(String prefix) {
        Trie1 node = this;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] != null) {
                node = node.next[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
