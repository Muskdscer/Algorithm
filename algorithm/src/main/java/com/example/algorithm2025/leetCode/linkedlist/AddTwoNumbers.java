package com.example.algorithm2025.leetCode.linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] listA = new int[]{2, 4, 3};
        int[] listB = new int[]{5, 6, 4};
        ListNode headA = new ListNode(listA[0]);
        ListNode headA1 = new ListNode(listA[1]);
        ListNode headA2 = new ListNode(listA[2]);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = null;
        ListNode headB = new ListNode(listB[0]);
        ListNode headB1 = new ListNode(listB[1]);
        ListNode headB2 = new ListNode(listB[2]);
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next = null;
        ListNode result = addTwoNumbers(headA, headB);
        System.out.println("相加以后链表的头结点是: " + result.val);
    }

    private static ListNode addTwoNumbers(ListNode headA, ListNode headB) {
        ListNode pre = new ListNode();
        ListNode cur = pre;
        int carry = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null && curB != null) {
            int x = curA != null ? curA.val : 0;
            int y = curB != null ? curB.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            curA = curA.next;
            curB = curB.next;
        }
        while (curA != null) {
            int x = curA != null ? curA.val : 0;
            int sum = carry + x;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            curA = curA.next;
        }
        while (curB != null) {
            int y = curB != null ? curB.val : 0;
            int sum = carry + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            curB = curB.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        ListNode head = reverse(pre.next);
        return head;
    }

    public static ListNode reverse(ListNode head) {
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
