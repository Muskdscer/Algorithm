package com.example.algorithm.designPattern.responsibility;

public class SecondPassHandler1 {

    /**
     * 第二关的下一关是 第三关
     * 具体处理者（Concrete Handler）：实现处理方法，判断是否能处理当前请求，如果不能则将请求转发给后继者。
     */
    private ThirdPassHandler1 thirdPassHandler1;

    public void setThirdPassHandler1(ThirdPassHandler1 thirdPassHandler1) {
        this.thirdPassHandler1 = thirdPassHandler1;
    }

    //本关卡游戏得分
    private int play(){
        return 90;
    }

    public int handler(){
        System.out.println("第二关-->SecondPassHandler");

        if(play() >= 90){
            //分数>=90 并且存在下一关才进入下一关
            if(this.thirdPassHandler1 != null){
                return this.thirdPassHandler1.handler();
            }
        }

        return 90;
    }
}
