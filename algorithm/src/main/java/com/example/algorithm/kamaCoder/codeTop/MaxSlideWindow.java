package com.example.algorithm.kamaCoder.codeTop;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxSlideWindow {
    static class MyQueue {
        Deque<Integer> que = new LinkedList<>();

        public void push(int val) {
            while (!que.isEmpty() && que.getLast() < val) {
                que.removeLast();
            }
            que.add(val);
        }

        public void  poll(int ch) {
            if (!que.isEmpty() && que.peek() == ch) {
                que.poll();
            }
        }

        public int getFront() {
            return que.peek();
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] temp = new int[nums.length - k + 1];
        int sum = 0;
        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        int num = 0;
        temp[num] = myQueue.getFront();
        num++;

        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.push(nums[i]);
            temp[num] = myQueue.getFront();
        }
        for (int i : temp) {
            System.out.println(i);
        }
    }
}
