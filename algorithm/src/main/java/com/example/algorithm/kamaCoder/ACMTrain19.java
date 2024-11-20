package com.example.algorithm.kamaCoder;

import java.util.Scanner;

public class ACMTrain19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            if (Integer.parseInt(str[0]) == 0) {
                System.out.println("list is empty");
            }
            ListNode dummyhead = new ListNode(-1);
            ListNode cur = dummyhead;
            //构造链表
            for (int i = 1; i < str.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(str[i]));
                cur.next = temp;
                cur = cur.next;
                if (i == str.length - 1) cur.next = null;
            }
            //输出原函数
            ListNode pointer = dummyhead.next;
            while (pointer != null) {
                System.out.print(pointer.val + " ");
                pointer = pointer.next;
            }
            System.out.println();

            //反转链表
            ListNode prev = null;
            ListNode curr = dummyhead.next;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            //输出反转链表
            ListNode pointer2 = prev;
            while (pointer2 != null) {
                System.out.print(pointer2.val + " ");
                pointer2 = pointer2.next;
            }
            System.out.println();
        }
    }

}
