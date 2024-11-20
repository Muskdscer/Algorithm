package com.example.algorithm.kamaCoder;

import java.util.Scanner;

public class ACMTrain20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            if (str[0].equals("0")) {
                System.out.println("list is empty");
            }

            ListNode dummyhead = new ListNode(-1);
            ListNode cur = dummyhead;
            //构造链表
            for (int i = 1; i < str.length; i++) {
                ListNode temp = new ListNode(Integer.parseInt(str[i]));
                cur.next = temp;
                cur = cur.next;
                if(i == str.length - 1) {
                    cur.next = null;
                }
            }
            //输出原始链表
            ListNode pointer01 = dummyhead.next;
            while(pointer01 != null) {
                System.out.print(pointer01.val + " ");
                pointer01 = pointer01.next;
            }
            System.out.println();
            //删除重复节点
            ListNode fast = dummyhead.next;
            ListNode slow = dummyhead;
            while(fast != null) {
                if(fast.val == slow.val) {
                    slow.next = fast.next;
                    fast = fast.next;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                }
            }

            //输出新链表
            ListNode pointer02 = dummyhead.next;
            while(pointer02 != null) {
                System.out.print(pointer02.val + " ");
                pointer02 = pointer02.next;
            }
            System.out.println();
        }
    }
}
