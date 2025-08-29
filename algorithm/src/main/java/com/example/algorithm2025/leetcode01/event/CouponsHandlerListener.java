package com.example.algorithm2025.leetcode01.event;

import org.springframework.stereotype.Component;

/**
 * 优惠券处理器
 */
@Component
public class CouponsHandlerListener implements BizEventListener{
    @Override
    public boolean decide(BizEvent event) {
        return true;
    }

    @Override
    public void onEvent(BizEvent event) {
        System.out.println("优惠券处理器:十折优惠券已发放");
    }
}
