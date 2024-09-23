package com.example.algorithm.twoPointers;

public class ListNode {
    int val;

    ListNode next;

    //无参构造
    public ListNode(){};

    //节点构造函数()
    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
