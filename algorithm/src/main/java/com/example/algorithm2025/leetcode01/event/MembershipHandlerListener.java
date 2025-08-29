package com.example.algorithm2025.leetcode01.event;

import org.springframework.stereotype.Component;

/**
 * 会员群处理器
 */
@Component
public class MembershipHandlerListener implements BizEventListener{
    @Override
    public boolean decide(BizEvent event) {
        return true;
    }

    @Override
    public void onEvent(BizEvent event) {
        System.out.println("会员群处理器:您已成功加入会员群");
    }
}
