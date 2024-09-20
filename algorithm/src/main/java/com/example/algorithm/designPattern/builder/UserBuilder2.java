package com.example.algorithm.designPattern.builder;

abstract class UserBuilder2 {
    User2 user;
    public abstract void username();
    public abstract void password();
    public abstract void email();
    public abstract void phone();
    public abstract void sex();

    public UserBuilder2(User2 user) {
        this.user = user;
    }

    public User2 getUser() {
        return user;
    }
}
