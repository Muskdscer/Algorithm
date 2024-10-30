package com.example.algorithm.designPattern.responsibility;

public class HandlerClient3 {
    public static void main(String[] args) {

        FirstPassHandler3 firstPassHandler3 = new FirstPassHandler3();//第一关
        SecondPassHandler3 secondPassHandler3 = new SecondPassHandler3();//第二关
        ThirdPassHandler3 thirdPassHandler3 = new ThirdPassHandler3();//第三关

        // 和上面没有更改的客户端代码相比，只有这里的set方法发生变化，其他都是一样的
        firstPassHandler3.setNext(secondPassHandler3);//第一关的下一关是第二关
        secondPassHandler3.setNext(thirdPassHandler3);//第二关的下一关是第三关

        //说明：因为第三关是最后一关，因此没有下一关

        //从第一个关卡开始
        firstPassHandler3.handler();

    }
}
