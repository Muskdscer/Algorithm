package com.example.algorithm2025.leetcode01.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 测试
 * http://localhost:8081/test/doRegisterVip?userName=zhangsan&age=28
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource(name = "eventEngineJob")
    private EventEngine eventEngine;

    @GetMapping("/doRegisterVip")
    public String doRegisterVip(@RequestParam(required = true) String userName,
                                @RequestParam(required = true) Integer age) {
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("userName", userName);
        paramMap.put("age", age);
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
        return "注册会员成功";
    }
}
