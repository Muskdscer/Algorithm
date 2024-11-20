package com.example.algorithm.kamaCoder;

import java.util.Scanner;

public class ACMTrain18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            linkedList.addFirst(num);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String operation = sc.next();
            if ("get".equals(operation)) {
                int a = sc.nextInt();
                int result = linkedList.get(a - 1);
                if (result != -1) {
                    System.out.println(result);
                } else {
                    System.out.println("get fail");
                }
            } else if ("delete".equals(operation)) {
                int a = sc.nextInt();
                boolean deleteResult = linkedList.delete(a - 1);
                if (deleteResult) {
                    System.out.println("delete OK");
                } else {
                    System.out.println("delete fail");
                }
            } else if ("insert".equals(operation)) {
                int a = sc.nextInt();
                int e = sc.nextInt();
                boolean insertResult = linkedList.insert(a - 1, e);
                if (insertResult) {
                    System.out.println("insert OK");
                } else {
                    System.out.println("insert fail");
                }
            } else if ("show".equals(operation)) {
                linkedList.show();
            }
        }
        sc.close();


    }

    /* 链表节点 */
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /* 链表 */
    static class LinkedList {
        private Node head;
        private int size;

        public LinkedList() {
            this.head = null;
            this.size = 0;
        }

        /* 头插法 */
        public void addFirst(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
        }

        /* 获取链表元素 */
        public int get(int idx) {
            int cnt = 0;
            Node curr = head;
            while (curr != null) {
                if (cnt == idx) {
                    return curr.val;
                }
                cnt++;
                curr = curr.next;
            }
            return -1;
        }

        /* 删除链表节点 */
        public boolean delete(int idx) {
            if (head == null || idx < 0 || idx >= size)
                return false;

            if (idx == 0) {
                head = head.next;
            } else {
                int cnt = 0;
                Node curr = head;
                while (cnt < idx - 1) {
                    curr = curr.next;
                    cnt++;
                }
                curr.next = curr.next.next;
            }
            size--;
            return true;
        }

        /* 插入元素 */
        public boolean insert(int idx, int val) {
            if (idx < 0 || idx > size)
                return false;

            if (idx == 0) {
                addFirst(val);
                return true;
            }

            int cnt = 0;
            Node curr = head;
            while (curr != null && cnt < idx - 1) {
                curr = curr.next;
                cnt++;
            }
            if (curr == null)
                return false;

            Node node = new Node(val);
            node.next = curr.next;
            curr.next = node;
            size++;
            return true;
        }

        /* 输出链表 */
        public void show() {
            if (head == null) {
                System.out.println("Link list is empty");
                return;
            }
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println();
        }

    }
}
