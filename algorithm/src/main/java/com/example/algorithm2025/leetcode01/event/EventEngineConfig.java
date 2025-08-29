package com.example.algorithm2025.leetcode01.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 事件驱动引擎配置
 */
@Configuration
public class EventEngineConfig {
    /**
     * 线程池异步处理事件
     */
    private static final Executor EXECUTOR = new ThreadPoolExecutor(20, 50, 10, TimeUnit.MINUTES,
            new LinkedBlockingQueue(500), new CustomizableThreadFactory("EVENT_ENGINE_POOL"));

    @Bean("eventEngineJob")
    public EventEngine initJobEngine(CouponsHandlerListener couponsHandlerListener,
                                     MembershipHandlerListener membershipHandlerListener,
                                     MsgHandlerListener msgHandlerListener) {
        Map<String, List<BizEventListener>> bizEvenListenerMap = new HashMap<>();
        //注册优惠券事件
        bizEvenListenerMap.put(EventEngineTopic.ISSUE_COUPONS, Arrays.asList(couponsHandlerListener));
        //注册会员群事件
        bizEvenListenerMap.put(EventEngineTopic.JOIN_MEMBERSHIP_GROUP, Arrays.asList(membershipHandlerListener));
        //注册消息推送事件
        bizEvenListenerMap.put(EventEngineTopic.SEND_WELCOME_MSG, Arrays.asList(msgHandlerListener));

        EventEngineImpl eventEngine = new EventEngineImpl();
        eventEngine.setBizSubscribers(bizEvenListenerMap);
        eventEngine.setAsync(true);
        eventEngine.setBizListenerExecutor(EXECUTOR);
        return eventEngine;
    }
}
