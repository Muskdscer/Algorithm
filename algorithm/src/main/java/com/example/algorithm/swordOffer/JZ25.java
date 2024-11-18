package com.example.algorithm.swordOffer;

import java.util.Scanner;

//合并两个有序链表
public class JZ25 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next().toString();
        String str2 = sc.next().toString();
        String[] arr1 = str1.split(",");
        String[] arr2 = str2.split(",");
        int[] int1 = new int[arr1.length];
        int[] int2 = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            int1[i] = Integer.parseInt(arr1[i]);
        }
        ListNode head1 = new ListNode(int1[0]);
        ListNode cur = head1;
        for (int i = 1; i < arr1.length; i++) {
            ListNode node = new ListNode(int1[i]);
            cur.next = node;
            cur = node;
        }

        for (int i = 0; i < arr2.length; i++) {
            int2[i] = Integer.parseInt(arr2[i]);
        }
        ListNode head2 = new ListNode(int2[0]);
        cur = head2;
        for (int i = 1; i < arr2.length; i++) {
            ListNode node = new ListNode(int2[i]);
            cur.next = node;
            cur = node;
        }

        ListNode result = merge(head1, head2);
        cur = result;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return head.next;
    }
}
