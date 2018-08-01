package com.example.demo.utils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 并发包测试
 * 多线程安全测试
 * 方法二
 * @author tzj
 * @create 2018-08-01 10:43
 **/
public class ConcurrentTest implements Runnable{
    private static int i=0;
    private static ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTest concurrentTest=new ConcurrentTest();
        Thread t1=new Thread(concurrentTest);
        Thread t2=new Thread(concurrentTest);
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println("main完成"+i);
    }
}
