package com.example.algorithm.kamaCoder.linkedList;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SwapPairs {
    static class ListNode{
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

            ListNode head = swap(dummy.next);
        }
    }

    private static ListNode swap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode temp;
        ListNode firstNode;
        ListNode secondNode;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dummy.next;
    }
}
