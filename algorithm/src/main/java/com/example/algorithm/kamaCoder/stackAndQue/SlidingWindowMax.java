package com.example.algorithm.kamaCoder.stackAndQue;

import java.util.Deque;
import java.util.LinkedList;

//单调队列
public class SlidingWindowMax {
    static class MyQueue {
        private Deque<Integer> queue = new LinkedList<>();

        public void push(int value) {
            while (!queue.isEmpty() && value > queue.peekLast()) {
                queue.removeLast();
            }
            queue.add(value);
        }

        public void pop(int ch) {
            //如果ch != queue.peek()  说明ch在之前queue.peek()加进队列的时候已经被挤出去了不用管了
            if (!queue.isEmpty() && ch == queue.peek()) {
                queue.pop();
            }
        }

        public int getFront() {
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow2(arr, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] maxSlidingWindow2(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return arr;
        }
        int num = 0;
        MyQueue myQueue = new MyQueue();
        int[] res = new int[arr.length - k + 1];
        for (int i = 0; i < k; i++) {
            myQueue.push(arr[i]);
        }
        res[num++] = myQueue.getFront();
        for (int i = k; i < arr.length; i++) {
            myQueue.pop(arr[i - k]);
            myQueue.push(arr[i]);
            res[num++] = myQueue.getFront();
        }
        return res;
    }
}
