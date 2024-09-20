package com.example.algorithm.linkedList;

public class RemoveElements {

    /**
     * 203. 移除链表元素
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
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
