package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis测试
 *
 * @author tzj
 * @create 2018-05-08 2:15
 **/
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/set")
    public Object set(){
        System.out.println("set!!!!!!!!!!!!!!!!!!");
        stringRedisTemplate.opsForValue().set("333","redis测试1");
        return "set333";
    }

    @RequestMapping("/get")
    public Object get(){
        System.out.println("get!!!!!!!!!!!!!!!!!!");
        String S=stringRedisTemplate.opsForValue().get("333");
        return S;
    }

    @RequestMapping("/set2")
    public Object set2(){
        System.out.println("set2!!!!!!!!!!!!!!!!!!");
        redisTemplate.opsForValue().set("111","测试2");
        return "set333";
    }


    @RequestMapping("/get2")
    public Object get2(){
        System.out.println("get2!!!!!!!!!!!!!!!!!!");
        String S=redisTemplate.opsForValue().get("111",1,1);
        return S;
    }
}
