package com.example.algorithm.kamaCoder.linkedList;

import java.util.*;
import java.io.*;
import java.lang.*;

public class RemoveElements {
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
            String[] str = sc.nextLine().split(" ");
            if (Integer.parseInt(str[0]) == 0) {
                System.out.println("list is empty");
            }
            ListNode dummyhead = new ListNode(-1);
            ListNode cur = dummyhead;
            //构造链表
            for (int i = 1; i < str.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(str[i]));
                cur.next = temp;
                cur = cur.next;
                if (i == str.length - 1) cur.next = null;
            }

            //移除链表
            ListNode node = removeElements(dummyhead.next, 5);
        }
    }

    private static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
