package com.example.algorithm.linkedList;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {//有环
                ListNode index1 = fast;
                ListNode index2 = head;
                //两个指针 从头结点和相遇节点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
