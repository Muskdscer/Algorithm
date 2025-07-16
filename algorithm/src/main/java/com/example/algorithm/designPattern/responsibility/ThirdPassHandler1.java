package com.example.algorithm.designPattern.responsibility;

public class ThirdPassHandler1 {

    //本关卡游戏得分
    private int play(){
        return 95;
    }

    /**
     * 这是最后一关，因此没有下一关
     * 具体处理者（Concrete Handler）：实现处理方法，判断是否能处理当前请求，如果不能则将请求转发给后继者。
     */
    public int handler(){
        System.out.println("第三关-->ThirdPassHandler，这是最后一关啦");
        return play();
    }
}
