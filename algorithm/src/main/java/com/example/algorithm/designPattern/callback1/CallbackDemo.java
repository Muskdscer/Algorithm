package com.example.algorithm.designPattern.callback1;

//实现回调接口并创建Caller对象
public class CallbackDemo {
    public static void main(String[] args) {
        Callback callback =  new Callback() {
            @Override
            public void onCallback(String message) {
                System.out.println("回调函数被调用: " + message);
            }
        };

        Caller caller = new Caller(callback);
        caller.doSomething();
    }
}
