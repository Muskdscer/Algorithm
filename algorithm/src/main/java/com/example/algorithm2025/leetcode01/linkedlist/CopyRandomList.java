package com.example.algorithm2025.leetcode01.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //构建新链表的next和random
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回新链表的头节点
        return map.get(head);
    }
}
