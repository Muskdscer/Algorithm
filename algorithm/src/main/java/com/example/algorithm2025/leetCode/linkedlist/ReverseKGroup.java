package com.example.algorithm2025.leetCode.linkedlist;

public class ReverseKGroup {
    public static void main(String[] args) {
        int[] listA = new int[]{4, 1, 8 , 4, 5, 6, 7, 1};
        ListNode headA = new ListNode(listA[0]);
        ListNode headA1 = new ListNode(listA[1]);
        ListNode headA2 = new ListNode(listA[2]);
        ListNode headA3 = new ListNode(listA[3]);
        ListNode headA4 = new ListNode(listA[4]);
        ListNode headA5 = new ListNode(listA[5]);
        ListNode headA6 = new ListNode(listA[6]);
        ListNode headA7 = new ListNode(listA[7]);

        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;
        headA4.next = headA5;
        headA5.next = headA6;
        headA6.next = headA7;
        headA7.next = null;

        ListNode head = reverseKGroup(headA, 3);
        System.out.println("k个一组翻转链表后的头结点是： " + head.val);
    }

    private static ListNode reverseKGroup(ListNode headA, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = headA;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            ListNode temp = swap(start);
            pre.next = temp;
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static ListNode swap(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }
        ListNode pre = null;
        ListNode cur = start;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
