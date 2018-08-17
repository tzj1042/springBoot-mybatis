package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: tzj
 * @Description:
 * @Date: 2018-02-23 15:35
 */
public interface UserService {
    List<User> getList (User user);
    int insert(User user);
    void testAsync();
    //调用存储过程查询版本号
    Map<String,Object> selectVersion();
    //调用存储过程根据id删除
    void callDeleteById(Integer id);
    //调用存储过程根据id删除，并返回剩余条数
    void deleteAndSelect(Map<String,Object> map);
    //调用存储过程返回结果集
    List<Map<String, Object>> selectAll();
}
