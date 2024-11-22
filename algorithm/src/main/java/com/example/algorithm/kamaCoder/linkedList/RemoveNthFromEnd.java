package com.example.algorithm.kamaCoder.linkedList;

import java.util.Scanner;

public class RemoveNthFromEnd {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            for (int i = 1; i < s.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(s[i]));
                cur.next = temp;
                cur = temp;
                if (i == s.length - 1) {
                    cur.next = null;
                }
            }

            ListNode head = removeNthFromEnd(dummy.next, 5);
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        while (k > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummyNode.next;
    }
}
