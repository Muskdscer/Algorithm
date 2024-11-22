package com.example.algorithm.kamaCoder.linkedList;

public class MyLinkedList {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;

    ListNode head;
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void  AddAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        size++;
    }

    public void AddAtTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
        }
        cur.next = newTail;
        newTail.next = null;
        size++;
    }

    public void AddAtIndex(int index, int val) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
