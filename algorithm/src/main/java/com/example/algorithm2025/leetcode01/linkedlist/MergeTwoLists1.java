package com.example.algorithm2025.leetcode01.linkedlist;

public class MergeTwoLists1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curA = list1;
        ListNode curB = list2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (curA != null && curB != null) {
            if (curA.val <= curB.val) {
                cur.next = curA;
                curA = curA.next;
                cur =cur.next;
            } else {
                cur.next = curB;
                curB = curB.next;
                cur = cur.next;
            }
        }

        while (curA != null) {
            cur.next = curA;
            curA = curA.next;
            cur = cur.next;
        }
        while (curB != null) {
            cur.next = curB;
            curB = curB.next;
            cur = cur.next;
        }
        return head.next;
    }
}
