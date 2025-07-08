package com.example.algorithm.designPattern.callback;

public class Worker {
    public void work(Callback<String> boss, String someWork) {
        String result = someWork + " is done";//做一些具体的处理
        boss.callback(result);//结果反馈给老板
    }
}
