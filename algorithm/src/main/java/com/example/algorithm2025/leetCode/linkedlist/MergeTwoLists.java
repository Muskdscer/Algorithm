package com.example.algorithm2025.leetCode.linkedlist;

public class MergeTwoLists {
    public static void main(String[] args) {
        int[] listA = new int[]{1, 3, 5 , 7, 9};
        int[] listB = new int[]{2, 4, 6, 8 , 10, 12};
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

        ListNode result = mergeTwoLists(headA, headB);
        System.out.println("合并后链表的头结点是： " + result.val);
    }

    private static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                cur.next = curA;
                cur = cur.next;
                curA = curA.next;
            } else {
                cur.next = curB;
                cur = cur.next;
                curB = curB.next;
            }
        }
        while (curA != null) {
            cur.next = curA;
            cur = cur.next;
            curA = curA.next;
        }
        while (curB != null) {
            cur.next = curB;
            cur = cur.next;
            curB = curB.next;
        }
        return head.next;
    }
}
