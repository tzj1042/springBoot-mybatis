package com.example.demo.mapper;

import com.example.demo.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getList(User record);

    Map<String,Object> selectVersion();

    void callDeleteById(Integer id);

    void deleteAndSelect(Map<String,Object> map);

    List<Map<String,Object>> selectAll();

}