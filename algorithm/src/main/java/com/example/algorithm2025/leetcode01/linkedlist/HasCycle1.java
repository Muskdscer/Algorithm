package com.example.algorithm2025.leetcode01.linkedlist;

//链表是否有环
public class HasCycle1 {
    public boolean hasCycle(ListNode head) {
        ListNode  slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
