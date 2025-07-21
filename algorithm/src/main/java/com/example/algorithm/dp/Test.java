package com.example.algorithm.dp;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("A线程执行。。。。。");
                }
            });
            threadA.start();
            threadA.join();

            Thread threadB = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("B线程执行。。。。。");
                }
            });

            threadB.start();
            threadB.join();

            Thread threadC = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("C线程执行。。。。。");
                }
            });

            threadC.start();
            threadC.join();
        }
    }
}
