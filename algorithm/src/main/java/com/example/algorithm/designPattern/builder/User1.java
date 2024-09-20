package com.example.algorithm.designPattern.builder;

public class User1 {
    //用户名
    private String username;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 手机号
    private String phone;
    // 性别
    private String sex;

    // 构造方法
    public User1(UserBuilder userBuilder) {
        this.username = userBuilder.getUsername();
        this.password = userBuilder.getPassword();
        this.email = userBuilder.getEmail();
        this.phone = userBuilder.getPhone();
        this.sex = userBuilder.getSex();
    }

    // 创建空的Userbuilder对象
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "User1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
