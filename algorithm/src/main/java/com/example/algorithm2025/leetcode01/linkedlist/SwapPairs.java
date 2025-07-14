package com.example.algorithm2025.leetcode01.linkedlist;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next.next;
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            cur.next = second;
            second.next = first;
            first.next = temp;
            cur = first;
        }
        return pre.next;
    }
}
