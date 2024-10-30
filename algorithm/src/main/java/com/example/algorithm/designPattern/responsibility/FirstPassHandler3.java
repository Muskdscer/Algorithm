package com.example.algorithm.designPattern.responsibility;

public class FirstPassHandler3 extends AbstractHandler{

    private int play(){
        return 80;
    }

    @Override
    public int handler(){
        System.out.println("第一关-->FirstPassHandler");
        int score = play();
        if(score >= 80){
            //分数>=80 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }
}
