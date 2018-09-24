package com.baiding.springboot.model;

/**
 * @Author: BaiDing
 * @Date: 2018/9/24 10:30
 * @Email: liujiabaiding@foxmail.com
 */
public class User {
    private long id;
    private String userName;
    private String userPassword;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
