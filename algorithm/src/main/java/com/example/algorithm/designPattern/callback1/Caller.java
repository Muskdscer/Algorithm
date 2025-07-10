package com.example.algorithm.designPattern.callback1;

//创建一个类Caller，该类接受回调接口作为参数，并在特定条件下调用回调方法
public class Caller {
    private Callback callback;

    public Caller(Callback callback) {
        this.callback = callback;
    }
    public void doSomething() {
        //执行一些操作
        String message = "操作完成";
        callback.onCallback(message);
    }
}
