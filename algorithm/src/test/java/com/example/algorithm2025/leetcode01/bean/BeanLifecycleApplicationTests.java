package com.example.algorithm2025.leetcode01.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest(classes = BeanLifecycleApplicationTests.class)
public class BeanLifecycleApplicationTests {
    @Autowired
    public MySpringBean mySpringBean;

    @Test
    public void testMySpringBeanLifecycle() {
        String message = "Hello World";
        mySpringBean.sendMessage(message);
        assertThat(mySpringBean.getMessage()).isEqualTo(message);
    }
}
