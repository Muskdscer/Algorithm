package com.example.algorithm.kamaCoder.stackAndQue;

import java.lang.*;
import java.util.*;
import java.io.*;

public class QueAsStack {
    static class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int val) {
            queue2.offer(val);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> queueTemp;
            queueTemp = queue1;
            queue1 = queue2;
            queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
    public static void main(String[] args) {

    }


}
