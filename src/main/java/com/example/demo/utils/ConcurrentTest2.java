package com.example.demo.utils;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并发包测试
 * 多线程安全测试
 * 方法三
 * @author tzj
 * @create 2018-08-01 10:43
 **/
public class ConcurrentTest2 {
    private static AtomicInteger i=new AtomicInteger(0);//可见性，原子性

   //private volatile static int i=0;//可见性

    public void run() {
        for (int j = 0; j < 100000; j++) {
                    i.addAndGet(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTest2 concurrentTest=new ConcurrentTest2();
        new Thread(
                ()->{
                    concurrentTest.run();
                    System.out.println("线程一"+i);
                }

        ).start();
        new Thread(
                ()->{
                    concurrentTest.run();
                    System.out.println("线程二"+i);
                }

        ).start();
        Thread.sleep(1000);
        System.out.println("main完成"+i);
    }
}
