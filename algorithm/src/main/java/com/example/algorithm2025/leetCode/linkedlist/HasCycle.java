package com.example.algorithm2025.leetCode.linkedlist;

public class HasCycle {
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
        boolean result = hasCycle(head);
        System.out.println("是否有环: " + result);
    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
