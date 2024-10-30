package com.example.algorithm.designPattern.responsibility;

/**
 * 没有使用责任链模式
 */
public class HandlerClient {
    public static void main(String[] args) {

        FirstPassHandler firstPassHandler = new FirstPassHandler();//第一关
        SecondPassHandler secondPassHandler = new SecondPassHandler();//第二关
        ThirdPassHandler thirdPassHandler = new ThirdPassHandler();//第三关

        int firstScore = firstPassHandler.handler();
        //第一关的分数大于等于80则进入第二关
        if(firstScore >= 80){
            int secondScore = secondPassHandler.handler();
            //第二关的分数大于等于90则进入第二关
            if(secondScore >= 90){
                thirdPassHandler.handler();
            }
        }
    }
}
