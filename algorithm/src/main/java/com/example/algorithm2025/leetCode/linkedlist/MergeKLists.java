package com.example.algorithm2025.leetCode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeKLists(ans, lists[i]);
        }
        return ans;
    }

    private static ListNode mergeKLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = head1, q = head2;
        ListNode cur = dummy;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                cur.next = p;
                p = p.next;
            } else  {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }

        cur.next = p == null ? q : p;
        return dummy.next;
    }
}
