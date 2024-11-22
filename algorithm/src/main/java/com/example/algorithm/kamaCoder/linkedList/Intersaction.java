package com.example.algorithm.kamaCoder.linkedList;

import java.util.Scanner;

public class Intersaction {

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

            String[] sB = sc.nextLine().split(" ");
            ListNode dummyB = new ListNode(-1);
            ListNode curB = dummyB;
            for (int i = 1; i < sA.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(sB[i]));
                curB.next = temp;
                curB = temp;
                if (i == sB.length - 1) {
                    curB.next = null;
                }
            }

            ListNode head = getIntersectionNode(dummyA.next, dummyB.next);

        }
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        //让A为长的
        if (lenB > lenA) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        int gap = lenA - lenB;

        while (gap-- > 0) {
            curA = curA.next;
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
