package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Config;
import com.example.demo.utils.Const;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    private DeferredResult<String> dr;
    private Random random=new Random();
    @Value("${ddd}")
    private String ddd;

    /**
     * 模板引擎测试Controller
     *
     * @param map
     * @return
     */
    @RequestMapping("/test")
    @Cacheable(value = "test")//接口响应加入缓存
    public String test(ModelMap map) {
        log.debug("哈哈！！！！！！！！！！！！！！！！！！！"+ Config.getPort());
        map.put("name", "小猪佩奇！！！");
        map.put("sex", 1);
        List<String> list = new ArrayList<>();
        list.add("小猪1");
        list.add("小猪22");
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

    /**
     * 事物测试
     * @return
     */
    @RequestMapping("/saveUser")
    @ResponseBody
    @Transactional
    public Object saveUser(User user) throws Exception{
        user.setPassword("密码是");
        user.setPhone("123444");
        user.setUserName("fdd");
        userService.insert(user);
        System.out.println("2222222222222"+9/0);
        return "事物测试";
    }

    //测试异步任务
    @RequestMapping("/testAsyncWork")
    @ResponseBody
    public Object testAsyncWork(){
        dr=new DeferredResult<String>();
        System.out.println(dr);
        return dr;
    }

    //定时更新内容
    @Scheduled(fixedRate = 3000)
    public void timed(){
        if (dr!=null){
            int s=random.nextInt(Const.STRINGS.length);
            System.out.println("3秒"+s);
            dr.setResult(Const.STRINGS[s]);
        }
    }

    //session测试
    @RequestMapping(value = "getSessionId")
    @ResponseBody
    public Object sessionId(HttpServletRequest request){
        String sessionId=request.getSession().getId();
        return sessionId;
    }

    //调用存储过程测试
    @RequestMapping(value = "call")
    @ResponseBody
    public Object call(Integer id){

        //return userService.selectVersion();

        //userService.callDeleteById(id);
        //return "succsez";

        /*HashMap<String, Object> m = new HashMap<>();
        m.put("id",id);
        userService.deleteAndSelect(m);
        return m;*/

        return userService.selectAll();
    }

    //测试获取application.properties
    @RequestMapping("/getProperties")
    @ResponseBody
    public String getProperties() {
        log.debug("获取配置文件参数"+ ddd);
        return ddd;
    }

}
