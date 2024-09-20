package com.example.algorithm.designPattern.builder;

public class Director {
    private UserBuilder2 userBuilder;

    public Director(UserBuilder2 userBuilder) {
        this.userBuilder = userBuilder;
    }

    public void makeUser() {
        userBuilder.username();
        userBuilder.email();
        userBuilder.password();
        userBuilder.sex();
        userBuilder.phone();
    }
}
