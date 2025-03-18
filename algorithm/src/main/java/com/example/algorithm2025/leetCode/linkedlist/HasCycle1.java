package com.example.algorithm2025.leetCode.linkedlist;

public class HasCycle1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 0, 4};
        ListNode head = new ListNode(nums[0]);
        ListNode node1 = new ListNode(nums[1]);
        ListNode node2 = new ListNode(nums[2]);
        ListNode node3 = new ListNode(nums[3]);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = head;
        ListNode result = hasCycle1(head);
        System.out.println("环的入口是: " + result.val);
    }

    private static ListNode hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode index1 = fast;
                ListNode index2 = head;
                //连个指针，从头节点和相遇节点各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
