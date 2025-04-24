package com.example.algorithm2025.leetCode.other;

import java.util.concurrent.TimeUnit;

public class TaskThread extends Thread {
    private static  volatile  boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            //
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TaskThread thread = new TaskThread();
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        stop = true;
    }
}
