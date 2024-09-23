package com.example.algorithm.twoPointers;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fastIndex = dummy;
        ListNode slowIndex = dummy;

        for (int i = 0; i <= n; i++) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        if (slowIndex.next != null) {
            slowIndex.next = slowIndex.next.next;
        }
        return dummy.next;
    }
}
