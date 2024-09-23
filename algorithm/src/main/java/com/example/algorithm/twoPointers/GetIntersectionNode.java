package com.example.algorithm.twoPointers;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        //让A链表为最长的那个
        if (lenA < lenB) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            ListNode temp = curA;
            curA = curB;
            curB = temp;
        }
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {//指针相同，值val相同，next也相同
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
