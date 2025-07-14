package com.example.algorithm2025.leetcode01.linkedlist;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            ListNode temp = swap(start);
            pre.next = temp;
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private  ListNode swap(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre =  cur;
            cur = temp;
        }
        return pre;
    }
}
