package com.example.algorithm2025.leetCode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public static void main(String[] args) {
        int[] listA = new int[]{1, 2, 2 , 1};
        ListNode headA = new ListNode(listA[0]);
        ListNode headA1 = new ListNode(listA[1]);
        ListNode headA2 = new ListNode(listA[2]);
        ListNode headA3 = new ListNode(listA[3]);
        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = null;
        boolean flag = isPalindrome(headA);
        System.out.println("是否是回文链表: " + flag);
    }

    public static boolean isPalindrome(ListNode headA) {
        List<Integer> vals = new ArrayList<>();
        while (headA != null) {
            vals.add(headA.val);
            headA = headA.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back) )) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
