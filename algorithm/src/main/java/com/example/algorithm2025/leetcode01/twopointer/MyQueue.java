package com.example.algorithm2025.leetcode01.twopointer;

//数组实现队列
public class MyQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //初始化
    public MyQueue(int arrmaxSize) {
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列满
    public boolean isFull() {
        return (rear + 1) == maxSize;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据
    public void addQueue(int val) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        rear = (rear + 1) % maxSize;
        arr[rear] = val;
    }
    //出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        front = (front + 1) % maxSize;
        return arr[front];
    }
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
    //显示队列头
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front+1];
    }
}
