package com.example.algorithm.designPattern.callback2;

public class Main {
    public static void main(String[] args) throws Exception {
        Request request = new Request();
        CallBack callBack = new CallBackImpl();
        new Thread(() -> {
            try {
                request.send(callBack);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
