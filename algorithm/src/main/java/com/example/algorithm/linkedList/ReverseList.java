package com.example.algorithm.linkedList;

import java.util.List;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;//保存下一节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
