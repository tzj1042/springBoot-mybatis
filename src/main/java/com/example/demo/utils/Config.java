package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件信息
 *
 * @author tzj
 * @create 2018-04-28 2:20
 **/
@Component
public class Config {

    @Value("ddd")
    private static String ddd;

    public static String getPort() {
        return ddd;
    }
}
