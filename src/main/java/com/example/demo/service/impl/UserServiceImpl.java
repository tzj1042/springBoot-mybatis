package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tzj
 * @Description:
 * @Date: 2018-02-23 15:35
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public List<User> getList(User user) {
        return userMapper.getList(user);
    }

    @Async
    public void testAsync(){
        System.out.println("3333333333333");
//        for (int i = 0; i < 5; i++) {
//            System.out.println("i:"+i);
//        }
        System.out.println("4444444444444");
    }
}
