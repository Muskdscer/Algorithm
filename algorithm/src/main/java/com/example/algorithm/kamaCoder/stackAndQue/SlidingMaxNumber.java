package com.example.algorithm.kamaCoder.stackAndQue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingMaxNumber {
    static class MyQue {
        private Deque<Integer> que = new LinkedList<>();
        public void poll(int ch) {
            //如果右边新加入的比que.peek()大，加进来放入头部没问题，如果比que.peek()加进来没问题，因为窗口要划过去了，所以必须要删除
            //如果还没有到que.peek()在原来队列的位置，不用删除，que.peek()这个最大值一直在队列的头部，不用删除 比que.peek()小的肯定是后进来的
            if (!que.isEmpty() && ch == que.peek()) {
                que.poll();
            }
        }

        public void push(int value) {
            while (!que.isEmpty() && value > que.peekLast()) {
                que.removeLast();
            }
            que.add(value);
        }

        public int getFront() {
            return que.peek();
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindowDemo(arr, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] maxSlidingWindowDemo(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        if (k == 1) {
            return arr;
        }
        int num = 0;

        MyQue myQue = new MyQue();
        int[] res = new int[arr.length - k + 1];
        for (int i = 0; i < k; i++) {
            myQue.push(arr[i]);
        }
        res[num++] = myQue.getFront();
        for (int i = k; i < arr.length - 1; i++) {
            myQue.poll(arr[i - k]);
            myQue.push(arr[i]);
            res[num++] = myQue.getFront();
        }
        return res;
    }
}
