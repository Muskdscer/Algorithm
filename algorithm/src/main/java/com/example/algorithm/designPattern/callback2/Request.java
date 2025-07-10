package com.example.algorithm.designPattern.callback2;

public class Request {
    public void send(CallBack callBack) throws Exception {
        // 模拟等待响应
        Thread.sleep(3000);
        System.out.println("[Request]: 收到响应");
        callBack.processResponse();
    }
}
