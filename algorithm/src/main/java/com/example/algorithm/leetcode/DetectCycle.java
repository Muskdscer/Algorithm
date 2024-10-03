package com.example.algorithm.leetcode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {//有环
                ListNode head1 = fast;
                ListNode head2 = head;

                while (head1 != head2) {
                    head1 = head1.next;
                    head2 = head2.next;
                }
                return head1;
            }
        }
        return null;
    }
}
