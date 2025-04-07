package com.example.algorithm2025.leetCode.graph;

public class Trie {
    private boolean isEnd;
    private Trie[] next;

    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] != null) {
                node = node.next[c - 'a'];
            }
            else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startWith(String prefix) {
        Trie node = this;
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
