package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
;

/**
 * @Author: tzj
 * @Description:
 * @Date: 2018-02-23 9:06
 */
//@RestController
@Controller
public class IndexController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    /**
     * 模板引擎测试Controller
     *
     * @param map
     * @return
     */
    @RequestMapping("/test")
    public String test(ModelMap map) {
        log.debug("哈哈！！！！！！！！！！！！！！！！！！！");
        map.put("name", "小猪佩奇！！！");
        map.put("sex", 1);
        List<String> list = new ArrayList<>();
        list.add("小猪1");
        list.add("小猪2");
        list.add("小猪3");
        map.put("list", list);
        return "test";
    }


    /**
     * 数据库操作测试
     *
     * @param user
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public Object getUser(User user) {
        log.debug("用户列表！");
        PageHelper.startPage(2, 2, false);
        List<User> list = userService.getList(user);
        return list;
    }

    /**
     * 异步测试
     *
     * @return
     */
    @RequestMapping("/testAsync")
    @ResponseBody
    public Object testAsync() {
        System.out.println("1111111111111");
        userService.testAsync();
        System.out.println("2222222222222");
        return "异步测试";
    }


}
