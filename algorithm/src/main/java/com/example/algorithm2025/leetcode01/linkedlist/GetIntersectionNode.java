package com.example.algorithm2025.leetcode01.linkedlist;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if (lenB > lenA) {
            ListNode temp = curA;
            curA = curB;
            curB= temp;
            int lenTemp = lenA;
            lenA = lenB;
            lenB = lenTemp;
        }

        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA== curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
