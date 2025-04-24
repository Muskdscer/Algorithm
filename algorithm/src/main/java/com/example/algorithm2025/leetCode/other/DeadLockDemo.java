package com.example.algorithm2025.leetCode.other;

public class DeadLockDemo {
    private static Object lock1 =  new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("thread1 get lock1");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("thread2 get lock2");
            }
            System.out.println("thread1 end");
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println("thread2 get lock2");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("thread1 get lock1");
            }
            System.out.println("thread2 end");
        }).start();
    }
}
