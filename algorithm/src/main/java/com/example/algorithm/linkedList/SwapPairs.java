package com.example.algorithm.linkedList;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);//设置第一个虚拟头结点
        dummyHead.next = head;
        ListNode curr = dummyHead;
        ListNode temp;
        ListNode firstNode;
        ListNode secondNode;
        while(curr.next != null && curr.next.next != null) {
            temp = curr.next.next.next;
            firstNode = curr.next;
            secondNode = curr.next.next;
            curr.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            curr = firstNode;
        }
        return dummyHead.next;
    }
}
