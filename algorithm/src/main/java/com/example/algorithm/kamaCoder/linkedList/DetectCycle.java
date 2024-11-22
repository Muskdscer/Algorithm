package com.example.algorithm.kamaCoder.linkedList;

import java.util.Scanner;

public class DetectCycle {
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
            String[] sA = sc.nextLine().split(" ");
            ListNode dummyA = new ListNode(-1);
            ListNode curA = dummyA;
            for (int i = 1; i < sA.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(sA[i]));
                curA.next = temp;
                curA = temp;
                if (i == sA.length - 1) {
                    curA.next = null;
                }
            }

            ListNode head = detectCycle(dummyA.next);
        }
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
