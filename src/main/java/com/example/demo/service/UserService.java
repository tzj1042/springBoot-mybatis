package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

/**
 * @Author: tzj
 * @Description:
 * @Date: 2018-02-23 15:35
 */
public interface UserService {
    List<User> getList (User user);
    void testAsync();
}
