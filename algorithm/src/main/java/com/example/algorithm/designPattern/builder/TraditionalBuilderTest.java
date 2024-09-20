package com.example.algorithm.designPattern.builder;

public class TraditionalBuilderTest {
    public static void main(String[] args) {
        // 创建一个空的用户
        User2 user = new User2();
        // 使用具体的构造者
        OneUserBuilder oneUserBuilder = new OneUserBuilder(user);
        // 可以控制建造者建造的顺序
        new Director(oneUserBuilder).makeUser();
        User2 user1 = oneUserBuilder.getUser();
        System.out.println(user1);
    }
}
