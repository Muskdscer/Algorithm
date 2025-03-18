package com.example.algorithm2025.leetCode.linkedlist;

public class SwapPairs {
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
        ListNode head = swapPairs(headA);
        System.out.println("两两交换后的头结点是： " + head.val);
    }

    private static ListNode swapPairs(ListNode headA) {
        ListNode pre = new ListNode(0);
        pre.next = headA;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next.next;
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            cur.next = second;
            second.next = first;
            first.next = temp;
            cur = first;
        }
        return pre.next;
    }
}
