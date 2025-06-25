package com.example.algorithm2025.leetCode.linkedlist;

public class GetIntersection {
    public static void main(String[] args) {
        int[] listA = new int[]{4, 1, 8 , 4, 5};
        int[] listB = new int[]{5, 0, 1, 8 , 4, 5};
        ListNode headA = new ListNode(listA[0]);
        ListNode headA1 = new ListNode(listA[1]);
        ListNode headA2 = new ListNode(listA[2]);
        ListNode headA3 = new ListNode(listA[3]);
        ListNode headA4 = new ListNode(listA[4]);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        headA4.next = null;
        ListNode headB = new ListNode(listB[0]);
        ListNode headB1 = new ListNode(listB[1]);
        ListNode headB2 = new ListNode(listB[2]);
        ListNode headB3 = new ListNode(listB[3]);
        ListNode headB4 = new ListNode(listB[4]);
        ListNode headB5 = new ListNode(listB[5]);
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;
        headB4.next = headB5;
        headB5.next = null;
        ListNode result = getIntersectionNode(headA, headB);
        System.out.println("相交的点是: " + result.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null) {
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
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
