package com.example.algorithm.designPattern.builder;

public class Test1 {
    public static void main(String[] args) {
        User1 user = User1.builder()
                .username("库里的球衣")
                .password("123456")
                .phone("12345678901")
                .email("123456@qq.com")
                .sex("男").build();
        System.out.println(user.toString());
    }
}
