package com.example.algorithm2025.leetCode.linkedlist;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        int[] listB = new int[]{5, 0, 1, 8 , 4, 5};
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
        ListNode result = removeNthFromEnd(headB, 3);
        System.out.println("删除倒数N个节点后头结点是： " + result.val);
    }

    private static ListNode removeNthFromEnd(ListNode headB, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = headB;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummyNode.next;
    }
}
