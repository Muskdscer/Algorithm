package com.example.xxl_job;

import org.springframework.stereotype.Service;

@Service
public class DemoJobService {
    public void demoTest(String s1){
        System.out.println("==============" + s1);
    }
}
