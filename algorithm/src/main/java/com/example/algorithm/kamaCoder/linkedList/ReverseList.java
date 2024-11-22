package com.example.algorithm.kamaCoder.linkedList;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ReverseList {
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
            if (Integer.parseInt(s[0] ) == 0) {
                System.out.println("长度不能为0");
            }

            int n = Integer.parseInt(s[0]);
            ListNode dummyNode = new ListNode(-1);
            ListNode cur = dummyNode;
            for (int i = 1; i < s.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(s[i]));
                cur.next = temp;
                cur = cur.next;
                if (i == s.length - 1) {
                    cur.next = null;
                }
            }

            ListNode head = reverse(dummyNode.next);
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre =  cur;
            cur = temp;
        }
        return pre;
    }
}
