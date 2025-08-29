package com.example.algorithm2025.leetcode01.event;

/**
 * 事件引擎topic，用于区分事件类型
 */
public class EventEngineTopic {
    /**
     * 入会员群
     */
    public static final String JOIN_MEMBERSHIP_GROUP = "joinMembershipGroup";

    /**
     * 发优惠券
     */
    public static final String ISSUE_COUPONS = "issueCoupons";

    /**
     * 推送消息
     */
    public static final String SEND_WELCOME_MSG = "sendWelcomeMsg";
}
