package com.example.algorithm.designPattern.build;

public class Client {
    public static void main(String[] args) {
        User user = User.builder()
                .username("库里的球衣")
                .password("123456")
                .phone("12345678901")
                .email("123456@qq.com")
                .sex("男").build();
        System.out.println(user);
    }
}
