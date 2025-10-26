package com.example.algorithm2025.leetcode01.linkedlist;

//环形链表
public class DetectCycle1 {
    public ListNode detectCycle(ListNode head) {
        ListNode  slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode index1 = fast;
                ListNode index2 = head;
                //连个指针，从头节点和相遇节点各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
