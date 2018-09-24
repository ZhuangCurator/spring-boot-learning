package com.baiding.springboot.dao;

import com.baiding.springboot.model.User;

import java.util.List;

/**
 * @Author: BaiDing
 * @Date: 2018/9/24 10:31
 * @Email: liujiabaiding@foxmail.com
 */
public interface UserDAO {

    List<User> getAllUser();

    User getUser(long id);
}
