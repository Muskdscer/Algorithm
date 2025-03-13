package com.example.algorithm2025.leetCode.linkedlist;

public class GetIntersectionNode {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println('d' - 'a');
        System.out.println('a' + 'A');
        System.out.println('a' + 3);
        System.out.println('A');
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA,  pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
