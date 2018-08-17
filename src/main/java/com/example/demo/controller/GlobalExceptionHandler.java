package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object resultError(Exception e){
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("code",500);
        resultMap.put("msg","服务器异常！！！");
        resultMap.put("err",e.getMessage());
        e.printStackTrace();
        return resultMap;
    }
}
