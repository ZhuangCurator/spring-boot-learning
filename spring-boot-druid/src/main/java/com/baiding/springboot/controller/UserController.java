package com.baiding.springboot.controller;

import com.baiding.springboot.dao.UserDAO;
import com.baiding.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: BaiDing
 * @Date: 2018/9/24 10:33
 * @Email: liujiabaiding@foxmail.com
 */
@RestController
public class UserController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userDAO.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id){
        return userDAO.getUser(id);
    }
}
