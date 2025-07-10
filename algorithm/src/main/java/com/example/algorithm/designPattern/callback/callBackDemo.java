package com.example.algorithm.designPattern.callback;

import javafx.concurrent.Task;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.*;

public class callBackDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //1.回调函数 Boss实现callBack接口类实现
//        Worker worker = new Worker();
//        Boss boss = new Boss(worker);//给老板指派员工
//        boss.makeBigDeals("coding");//老板有代码要写

        //2.回调函数 lamda表达式实现
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        new Callback<String>() {
//            Worker worker = new Worker();
//            @Override
//            public void callback(String s) {
//                System.out.println();
//                System.out.println("老板拿到结果： {}" + s);
//                countDownLatch.countDown();
//            }
//
//            void makeBigDeal(String deal) {
//                System.out.println("分配工作...");
//                new Thread(() -> worker.work(this, deal), "worker").start();
//                System.out.println("分配完工作。");
//                System.out.println("老板下班回家了。。。。");
//            }
//        }.makeBigDeal("A big deal");
//        countDownLatch.await();



        //3.回调地狱
        //将任务交给产品经理
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        //主线程是Boss
//        new Callback<String>() {
//            private Worker productManager = new Worker();
//
//            //String s是产品productManager回调的结果
//            @Override
//            public void callback(String s) {
//                //System.out.println("产品经理 output: " + s);//获取产品经理的输出
//                //再将产品经理输出交给开发
//                System.out.println("老板：拿到结果，交给程序员：" + s);
//                new Thread(() -> {
//                    new Callback<String>() {
//                        private Worker coder = new Worker();
//
//                        @Override
//                        public void callback(String s) {
//                            System.out.println("程序员：完成任务" + s);
//                            countDownLatch.countDown();
//                        }
//
//                        public void  coding(String coding) {
//                            coder.work(this, coding);//在这里的this是产品，所以回调给产品，如果需要回调给boss这里输入则是boss
//                        }
//                    }.coding(s);
//                }, "coder").start();
//            }
//
//            public void makeBigDeals(String bigDeal) {
//                System.out.println("Boss将任务交给产品");
//                new Thread(() -> {
//                    this.productManager.work(this, bigDeal);//异步调用产品经理处理过程
//                }, "Product").start();
//            }
//        }.makeBigDeals("一个大项目");
//        System.out.println("老板：下班回家");
//        countDownLatch.await();


//        //4.Reactor解决回调地狱问题
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        Mono.defer(() -> {
//            System.out.println("老板：将任务交给产品");
//            return Mono.just("项目");
//        }).publishOn(Schedulers.newSingle("Product")).map(s -> {
//            System.out.println("产品经理：开始工作");
//            String midResult = "设计(" + s + ")";
//            System.out.println("产品经理：处理任务并给出原型: " + midResult);
//            System.out.println("产品经理：将任务交给程序员");
//            return midResult;
//        }).publishOn(Schedulers.newSingle("Coder")).map(s -> {
//            System.out.println("程序员：开始工作");
//            String result = "编程(" + s + ")";
//            System.out.println("程序员：完成任务{}" + result);
//            return result;
//        }).subscribe(result -> {
//            System.out.println("项目完成：" + result);
//            countDownLatch.countDown();
//        });
//        System.out.println("老板：下班回家");
//        countDownLatch.await();


        //5.和Future对比 提到异步回调不会阻塞主线程，那么使用Future也不会阻塞
        //回调和Future有什么区别。1）两者机制不同；2）Future在等待结果时会阻塞，而回调不会阻塞。
        //虽然Worker工作是异步的，但是老板获取工作的结果（future.get()）的时候却需要等待，而这个等待的过程是阻塞的。这是回调和Future一个显著的区别
        //如何解决回调地狱。最常见的则是反应式编程RxJava和Reactor
//        System.out.println("分配工作...");
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> worker.work(someDetail));
//        System.out.println("分配完工作。");
//        System.out.println("老板下班回家了。。。");
//        System.out.println("boss got the feedback from worker: {}" + future.get());

        //5.Java中的Future使用
        //Future 是一个接口，它代表了异步计算的结果。
        // 它提供了一种检查计算是否完成的方法（futureTask1.isDone()），等待计算完成，并检索计算结果的方法。
        // 当你执行一个耗时的计算任务时，使用Future可以让你在计算完成后获取结果，同时可以继续执行其他任务
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2100);
                return "任务完成";
            }
        });
        //从Future获取结果
        String result = future.get(); // 这可能会阻塞
        System.out.println(result);


        Callable<String> ca1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        Callable<String> ca2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000 * 3);
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        if (ft1.isDone()) {
            System.out.println(ft1.get());
        } else {
            System.out.println("任务1没有执行完成！");
        }
        if (ft2.isDone()) {
            System.out.println(ft2.get());
        } else {
            System.out.println("任务2没有执行完成！");
        }

    }
}
