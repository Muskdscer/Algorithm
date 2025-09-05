package com.example.algorithm2025.leetcode01.linkedlist;

public class MergeKLists1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode curA = l1;
        ListNode curB = l2;
        ListNode cur = dummy;
        while (curA != null && curB != null) {
            if (curA.val <= curB.val) {
                cur.next = curA;
                curA = curA.next;
            } else {
                cur.next = curB;
                curB = curB.next;
            }
            cur = cur.next;
        }
        cur.next = curA == null ? curB : curA;
        return dummy.next;
    }
}
