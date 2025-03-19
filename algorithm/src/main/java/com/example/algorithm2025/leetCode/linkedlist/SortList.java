package com.example.algorithm2025.leetCode.linkedlist;

import java.util.List;

public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println("排序后的头结点是： " + sortList(head).val);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while(cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = merge(head1, head2);
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummy.next;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummpy = new ListNode(0);
        ListNode cur = dummpy;
        ListNode curA = head1, curB = head2;
        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                cur.next = curA;
                cur = curA;
                curA = curA.next;
            } else {
                cur.next = curB;
                cur = curB;
                curB = curB.next;
            }
        }
        while (curA != null) {
            cur.next = curA;
            cur = curA;
            curA = curA.next;
        }
        while (curB != null) {
            cur.next = curB;
            cur = curB;
            curB = curB.next;
        }
        return dummpy.next;
    }
}
