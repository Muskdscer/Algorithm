package com.example.algorithm.designPattern.builder;

public class UserBuilder {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UserBuilder() {
    }
    // 加入所有的getter方法

    // 为每一个属性提供赋值的方法， 并返回当前的对象
    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }
    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserBuilder sex(String sex) {
        this.sex = sex;
        return this;
    }

    // 加入build方法， 用于返回Useruser对象
    public User1 build() {
        return new User1(this);
    }
}
