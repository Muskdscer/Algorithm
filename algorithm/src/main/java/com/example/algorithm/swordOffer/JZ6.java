package com.example.algorithm.swordOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//倒序输出链表
public class JZ6 {
    //构造链表节点
    static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //处理输入同时构造成链表
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toString();
        String[] arr = str.split(",");
        int[] ints = new int[arr.length];
        for(int i = 0; i< arr.length; i++) {
            ints[i] = Integer.parseInt(arr[i]);
        }
        ListNode head = new ListNode(ints[0]);
        ListNode cur = head;
        for(int i = 1; i<ints.length; i++) {
            ListNode node = new ListNode(ints[i]);
            cur.next = node;
            cur = node;
        }
        List<Integer> list = solution(head);
        System.out.println(list);
    }

    public static List<Integer> solution(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
