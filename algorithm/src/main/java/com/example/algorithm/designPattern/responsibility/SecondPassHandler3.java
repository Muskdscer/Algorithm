package com.example.algorithm.designPattern.responsibility;

public class SecondPassHandler3 extends AbstractHandler{

    private int play(){
        return 90;
    }

    public int handler(){
        System.out.println("第二关-->SecondPassHandler");

        int score = play();
        if(score >= 90){
            //分数>=90 并且存在下一关才进入下一关
            if(this.next != null){
                return this.next.handler();
            }
        }

        return score;
    }
}
