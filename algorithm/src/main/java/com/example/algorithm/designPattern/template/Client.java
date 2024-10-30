package com.example.algorithm.designPattern.template;

public class Client {
    public static void main(String[] args)
    {
        //制作红豆豆浆
        ReadBeanSoyaMilk readBeanSoyaMilk = new ReadBeanSoyaMilk();
        readBeanSoyaMilk.make();
        System.out.println("------------------------");
        //制作花生豆浆
        PeanutSoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
    }
}
