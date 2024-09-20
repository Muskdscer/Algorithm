package com.example.algorithm.designPattern.builder;

public class OneUserBuilder extends UserBuilder2{
    public OneUserBuilder(User2 user) {
        super(user);
    }
    @Override
    public void username() {
        user.setUsername("库里的球衣");
    }

    @Override
    public void password() {
        user.setPassword("123456");
    }

    @Override
    public void email() {
        user.setEmail("123456@qq.com");
    }

    @Override
    public void phone() {
        user.setPhone("12345678901");
    }

    @Override
    public void sex() {
        user.setSex("男");
    }
}
