package com.example.algorithm2025.leetcode01.linkedlist;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        sort(node,null);
        return node.next;
    }

    public void sort(ListNode head,ListNode end) {
        if(head == end || head.next == end || head.next.next == end){
            return;
        }
        ListNode cur = head.next;
        ListNode pre = head.next;
        while(pre != end && pre.next != end){
            ListNode node = pre.next;
            if(node.val < cur.val){
                pre.next = pre.next.next;
                ListNode tt = head.next;
                head.next = node;
                node.next = tt;
            } else {
                pre = pre.next;
            }
        }
        sort(head,cur);
        sort(cur,end);
    }
}
