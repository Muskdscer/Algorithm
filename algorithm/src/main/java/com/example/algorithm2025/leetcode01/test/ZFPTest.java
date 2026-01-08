package com.example.algorithm2025.leetcode01.test;

//智平方面试题
public class ZFPTest {
    public LinkedListNode findNode(LinkedListNode startNode) {
        LinkedListNode fast = startNode;
        LinkedListNode slow  = startNode;
        while (fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                LinkedListNode newSlow = startNode;
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
