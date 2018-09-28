package com.baiding.springboot.model;

import java.io.Serializable;

/**
 * @Author: BaiDing
 * @Date: 2018/9/28 22:45
 * @Email: liujiabaiding@foxmail.com
 */
public class Student implements Serializable{

    private long id;
    private String name;
    private String gender;

    public Student(){}

    public Student(long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
