package com.example.algorithm.designPattern.responsibility;

public class FirstPassHandler1 {
    /**
     * 第一关的下一关是 第二关
     * 具体处理者（Concrete Handler）：实现处理方法，判断是否能处理当前请求，如果不能则将请求转发给后继者。
     */
    private SecondPassHandler1 secondPassHandler1;

    public void setSecondPassHandler1(SecondPassHandler1 secondPassHandler1) {
        this.secondPassHandler1 = secondPassHandler1;
    }

    //本关卡游戏得分
    private int play(){
        return 80;
    }

    public int handler(){
        System.out.println("第一关-->FirstPassHandler");
        if(play() >= 80){
            //分数>=80 并且存在下一关才进入下一关
            if(this.secondPassHandler1 != null){
                return this.secondPassHandler1.handler();
            }
        }

        return 80;
    }
}
