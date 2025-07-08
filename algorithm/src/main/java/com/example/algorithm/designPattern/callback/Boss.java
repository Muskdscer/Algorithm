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
        new Thread(() -> worker.work(Boss.this, someDetail)).start();//异步完成任务
        log.info("分配完成");
        log.info("老板下班。。。");
    }
}
