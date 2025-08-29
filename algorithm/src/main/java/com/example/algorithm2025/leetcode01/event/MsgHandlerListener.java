package com.example.algorithm2025.leetcode01.event;

import org.springframework.stereotype.Component;

/**
 * 消息推送处理器
 */
@Component
public class MsgHandlerListener implements BizEventListener{
    @Override
    public boolean decide(BizEvent event) {
        return true;
    }

    @Override
    public void onEvent(BizEvent event) {
        System.out.println("消息推送处理器:欢迎成为会员！！！");
    }
}
