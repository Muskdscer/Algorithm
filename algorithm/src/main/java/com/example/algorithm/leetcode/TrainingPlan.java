package com.example.algorithm.leetcode;

public class TrainingPlan {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode former = head, latter = head;
        for(int i = 0; i < cnt; i++) {
            former = former.next;
        }
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
