package com.example.algorithm2025.leetCode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode listNode : lists) {
            while (listNode != null) {
                priorityQueue.add(listNode);
                listNode = listNode.next;
            }
        }
        ListNode newHead = priorityQueue.poll();
        ListNode ret = newHead;
        if (newHead != null) {
            while (!priorityQueue.isEmpty()) {
                newHead.next = priorityQueue.poll();
                newHead = newHead.next;
            }
        }
        if (newHead != null) {
            newHead.next = null;
        }
        return ret;
    }
}
