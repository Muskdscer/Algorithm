package com.example.algorithm.designPattern.template;

public class PureMilk extends SoyaMilk1{
    @Override
    void addCondiments() {
        System.out.println("不加配料");
    }

    @Override
    boolean customerWantCondiment() {
        return true;
    }
}
