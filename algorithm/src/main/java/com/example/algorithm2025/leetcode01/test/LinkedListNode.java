package com.example.algorithm2025.leetcode01.test;

//智平方面试题
public class LinkedListNode {
    int val;
    LinkedListNode pre;
    LinkedListNode next;

    public LinkedListNode() {
    }

    public LinkedListNode(int val, LinkedListNode pre, LinkedListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public LinkedListNode getPre() {
        return pre;
    }

    public LinkedListNode getNext() {
        return next;
    }
}
