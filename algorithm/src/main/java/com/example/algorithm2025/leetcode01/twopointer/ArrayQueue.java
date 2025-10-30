package com.example.algorithm2025.leetcode01.twopointer;

public class ArrayQueue {
    private int maxSize;
    private int front;//头
    private int rear;//尾
    private int[] arr;
    //初始化
    public ArrayQueue(int arrmaxSize) {
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列满
    public boolean isFull() {
        return (rear+1) == maxSize;
    }
    //判断队列kong
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据
    public void addQueue(int n) {
        if(isFull()) {//判满
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    //出队列
    public int getQueue() {
        if(isEmpty()) {//判空
            throw new RuntimeException("队列空");
        }
        front++;
        return arr[front];
    }
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for(int i = front; i < rear; i++) {
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
    //显示队列头
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front+1];
    }
}
