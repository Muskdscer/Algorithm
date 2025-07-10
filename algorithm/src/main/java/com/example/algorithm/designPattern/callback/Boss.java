package com.example.algorithm.designPattern.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss implements Callback<String> {
    private Worker worker;
    public Boss(Worker worker) {
        this.worker = worker;
    }
    @Override
    public void callback(String result) {
        log.info("Boss got:{}" + result);
    }

    public void makeBigDeals(final String someDetail) {
        log.info("分配工作");
        //异步回调
        //解耦，回调将子过程从主过程中解耦 对于主流程，我们只关心子过程的输入和输出，输入在上面的例子中即为Worker.work中的参数，而子过程的输出则是主过程的callback方法的参数
        //异步回调不会阻塞主线程。上面的例子清晰可以看到，员工没有完成工作之前老板就已经下班，当工作完成后，会通过另一个线程通知老板。老板在这个过程无需等待子过程
        new Thread(() -> worker.work(Boss.this, someDetail)).start();//异步完成任务
        log.info("分配完成");
        log.info("老板下班。。。");
    }
}
