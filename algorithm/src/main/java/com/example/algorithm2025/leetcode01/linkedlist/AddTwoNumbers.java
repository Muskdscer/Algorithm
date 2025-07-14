package com.example.algorithm2025.leetcode01.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        ListNode curA = l1;
        ListNode curB = l2;
        while (curA != null && curB != null) {
            int x = curA == null ? 0 : curA.val;
            int y = curB == null ? 0 : curB.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            curA = curA.next;
            curB = curB.next;
        }

        while (curA != null) {
            int x = curA == null ? 0 : curA.val;
            int sum =  x + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            curA = curA.next;
        }

        while (curB != null) {
            int y =  curB == null ? 0 : curB.val;
            int sum =  y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            curB = curB.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }

        ListNode head1 = reverse(head.next);
        return head1;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
