package com.example.algorithm.leetcode;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur =  head;
        ListNode temp;
        while(cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
