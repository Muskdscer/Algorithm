package com.example.algorithm2025.leetCode.other;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    //异步操作
/*    public static void main(String[] args) {
        //异步执行 无返回值
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("future1 start");
            //模拟异步读取文件或执行数据库操作
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("future1 end");
            System.out.println("文件内容为java技术栈");
        });

        //异步执行（有返回值）
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 start");
            //模拟异步读取文件或数据库操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("future2 end");
            return "java技术栈";
        });
        System.out.println("文件2内容为" + future2.join());
    }*/


    //链式调用依赖
/*    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            //任务A
            return 100;
        }).thenApply(result -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //依赖于任务A的任务B
            return result + 200;
        }).thenApply(result -> {
            //依赖于任务B的任务C
            return result + 300;
        }).thenAccept(result -> {
            //最终结果
            System.out.println("最终结果" + result);
        });
    }*/

    //并行异步处理(聚合)
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future1 start");
            //模拟异步读取文件或数据库操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("future1 end");
            return 100;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 start");
            //模拟异步读取文件或数据库操作
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("future2 end");
            return 200;
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        CompletableFuture<Integer> resultFuture = combinedFuture.thenApply((result) -> {
            //处理所有任务的结果
            int result1 = future1.join();
            int result2 = future2.join();
            return result1 + result2;
        });
        System.out.println("最终结果：" + resultFuture.join());
    }

    //异步并行处理(取任意一个)
/*    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future1 start");
            //模拟异步读取文件或数据库操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("future1 end");
            return 100;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 start");
            //模拟异步读取文件或数据库操作
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("future2 end");
            return 200;
        });

        //最快完成的任务
        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future1, future2);
        System.out.println("最终结果" + anyFuture.join());
    }*/

    //异步回调处理
/*    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //使用whenComplete 无返回值
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 100);
        future1.whenComplete((result, throwable) -> {
            if (throwable == null) {
                System.out.println("任务1成功，结果是" + result);
            } else {
                System.out.println("任务1失败，异常是" + throwable.getMessage());
            }
        });

        //使用handle 有返回值
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 200);
        CompletableFuture<Integer> handle = future2.handle((result, throwable) -> {
            if (throwable != null) {
                System.out.println("任务2失败，异常是" + throwable.getMessage());
                return -1;
            }
            return result + 100;
        });
        System.out.println("任务2成功，结果是" + handle.get());
    }*/


    //异步任务超时处理
/*    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            //模拟耗时操作
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "小程序，java面试";
        }).orTimeout(3, TimeUnit.SECONDS).exceptionally(ex - {
                System.out.println("任务超时返回默认值");
                return "公众号 java技术栈";
        });
        System.out.println(future.get());
    }*/
}
