package com.example.algorithm2025.leetCode.linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        int[] listA = new int[]{4, 1, 8 , 4, 5};
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
        ListNode result = reverseList(headA);
        System.out.println("翻转后的头结点是: " + result.val);
    }

    public static ListNode reverseList(ListNode headA) {
        ListNode pre = null;
        ListNode cur = headA;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
