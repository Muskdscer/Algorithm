package com.example.algorithm.designPattern.callback2;

public class CallBackImpl implements CallBack{
    @Override
    public void processResponse() {
        System.out.println("[CallBack]: 处理响应");
    }
}
