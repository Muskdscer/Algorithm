package com.example.algorithm.designPattern.template;

public class PureMilk extends SoyaMilk1{
    //覆盖添加配料方法决定加什么配料
    @Override
    void addCondiments() {
        System.out.println("不加配料");
    }

    //覆盖钩子方法决定是否要添加配料 return true or false
    @Override
    boolean customerWantCondiment() {
        return true;
    }
}
