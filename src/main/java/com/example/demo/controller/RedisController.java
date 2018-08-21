package com.example.demo.controller;

import com.example.demo.service.RedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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
    @Autowired
    private RedisTemplateService redisTemplateService;


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
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer );
        redisTemplate.setValueSerializer(stringSerializer );
        redisTemplate.setHashKeySerializer(stringSerializer );
        redisTemplate.setHashValueSerializer(stringSerializer );
        System.out.println("set2!!!!!!!!!!!!!!!!!!");
        redisTemplate.opsForValue().set("111","test2");
        return "set333";
    }


    @RequestMapping("/get2")
    public Object get2(){
        System.out.println("get2!!!!!!!!!!!!!!!!!!");
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer );
        redisTemplate.setValueSerializer(stringSerializer );
        redisTemplate.setHashKeySerializer(stringSerializer );
        redisTemplate.setHashValueSerializer(stringSerializer );
        String S=redisTemplate.opsForValue().get("111").toString();
        return S;
    }
    @RequestMapping("/set3")
    public Object set3(){
        redisTemplateService.stringSetString("re","测试3");
        return "33";
    }

    @RequestMapping("/get3")
    public Object get3(){
        String S=redisTemplateService.stringGetStringByKey("re");
        return S;
    }

}
