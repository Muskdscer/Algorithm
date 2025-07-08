package com.example.algorithm.designPattern.callback;

public class callBackDemo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Boss boss = new Boss(worker);//给老板指派员工
        boss.makeBigDeals("coding");//老板有代码要写
    }
}
