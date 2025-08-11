package com.example.algorithm.designPattern.responsibility;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 客户端（Client）：创建处理链，并向链头的具体处理者对象提交请求
 */
public class HandlerClient1 {

//    //DynamicTp
//    @Resource
//    @DynamicTp("demoThreadPool")
//    private ThreadPoolExecutor demoThreadPool;

    @Resource
    private static Redisson redisson;

    @Resource
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        FirstPassHandler1 firstPassHandler1 = new FirstPassHandler1();//第一关
        SecondPassHandler1 secondPassHandler1 = new SecondPassHandler1();//第二关
        ThirdPassHandler1 thirdPassHandler1 = new ThirdPassHandler1();//第三关

        firstPassHandler1.setSecondPassHandler1(secondPassHandler1);//第一关的下一关是第二关
        secondPassHandler1.setThirdPassHandler1(thirdPassHandler1);//第二关的下一关是第三关

        //说明：因为第三关是最后一关，因此没有下一关
        //开始调用第一关 每一个关卡是否进入下一关卡 在每个关卡中判断
        firstPassHandler1.handler();

        RLock myLock = redisson.getLock("myLock");
        myLock.lock();

        lock.lock();
        lock.unlock();

    }
}
