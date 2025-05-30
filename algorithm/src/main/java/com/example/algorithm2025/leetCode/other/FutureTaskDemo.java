package com.example.algorithm2025.leetCode.other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "futureTask1 执行完成";
            }
        });
        new Thread(futureTask1).start();

        FutureTask<String> futureTask2 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2100);
                return "futureTask2 执行完成";
            }
        });
        new Thread(futureTask2).start();

        while (true) {
            //isDone() 方法作用是，判断任务是否执行完毕，通常在程序中轮询使用
            if (futureTask1.isDone() && futureTask2.isDone()) {
                //get() 方法的作用是，以阻塞方式，获取任务执行结果
                System.out.println(futureTask1.get());
                System.out.println(futureTask2.get());
                break;
            }
        }
    }
}
