package com.example.algorithm2025.leetcode01.test;

//智平方面试题
public class ZFPTest {
    public LinkedListNode findNode(LinkedListNode startNode) {
        LinkedListNode dummy = new LinkedListNode();
        dummy.next = startNode;
        LinkedListNode fast = dummy;
        LinkedListNode slow  = dummy;
        while (fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) {
                LinkedListNode newSlow = dummy;
                LinkedListNode newFast = fast;
                while (newSlow.next != null && newFast.next != null) {
                    newFast = newFast.next;
                    newSlow = newSlow.next;
                    if (newFast.val == newSlow.val) {
                        return newFast;
                    }
                }
            }
        }
        return null;
    }
}
