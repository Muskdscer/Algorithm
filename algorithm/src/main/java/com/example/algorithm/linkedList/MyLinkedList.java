package com.example.algorithm.linkedList;

import jdk.nashorn.internal.ir.WhileNode;

public class MyLinkedList {
    int size;

    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = head;
        for (int i = 0; i <= index; ++i) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
