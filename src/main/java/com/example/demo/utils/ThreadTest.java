package com.example.demo.utils;

/**
 * 多线程安全测试
 * 方法一
 * 方法二 ConcurrentTest
 * 方法三 ConcurrentTest2
 * @author tzj
 * @create 2018-08-01 10:16
 **/
public class ThreadTest implements Runnable{
    private static int i=0;

    @Override
    public  synchronized void run() {
        for (int j = 0; j < 100000; j++) {
            synchronized(this) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest concurrentTest=new ThreadTest();
        Thread t1 =new Thread(concurrentTest);
        Thread t2=new Thread(concurrentTest);
        t1.start();
        t2.start();

        //方法一 main主线休眠，等待子线程执行完成
        Thread.sleep(2000);

        //等待该线程终止
        //t1.join();
        //t2.join();
        System.out.println("main完成"+i);
    }
}

