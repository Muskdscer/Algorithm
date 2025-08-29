package com.example.algorithm2025.leetcode01;

import com.example.algorithm2025.leetcode01.event.BizEvent;
import com.example.algorithm2025.leetcode01.event.EventEngine;
import com.example.algorithm2025.leetcode01.event.EventEngineTopic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoRegisterVipTest {

    @Resource
    private EventEngine eventEngine;

    @Test
    public void test() {
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("userName", "张三");
        paramMap.put("age", 28);
        //1、注册会员，这里不实现了
        System.out.println("注册会员成功");
        //2、入会员群
        eventEngine.publishEvent(
                new BizEvent(EventEngineTopic.JOIN_MEMBERSHIP_GROUP, UUID.randomUUID().toString(), paramMap));
        //3、发优惠券
        eventEngine.publishEvent(
                new BizEvent(EventEngineTopic.ISSUE_COUPONS, UUID.randomUUID().toString(), paramMap));
        //4、推送消息
        eventEngine.publishEvent(
                new BizEvent(EventEngineTopic.SEND_WELCOME_MSG, UUID.randomUUID().toString(), paramMap));
    }
}
