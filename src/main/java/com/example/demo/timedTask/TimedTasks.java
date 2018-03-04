package com.example.demo.timedTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class TimedTasks {

    @Scheduled(fixedRate = 1000)
    public void  timed(){
        System.out.println("每隔一秒钟执行！！");
    }
}
