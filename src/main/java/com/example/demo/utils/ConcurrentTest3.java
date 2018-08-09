package com.example.demo.utils;


/**
 * 多线程安全测试
 * 方法三
 * @author tzj
 * @create 2018-08-01 10:43
 **/
public class ConcurrentTest3 {
    private static ThreadLocal<Integer> i=new ThreadLocal<>();
    private  static int sum =0;

    public void run() {
        i.set(0);
        for (int j = 0; j < 100000; j++) {
            i.set(i.get()+1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentTest3 concurrentTest=new ConcurrentTest3();
        System.out.println("iiiiii"+i.get());
        new Thread(
                ()->{
                    concurrentTest.run();
                    sum +=i.get();
                    System.out.println("线程一"+i.get());
                }

        ).start();

        new Thread(
                ()->{
                    concurrentTest.run();
                    sum +=i.get();
                    System.out.println("线程二"+i.get());
                }

        ).start();

        Thread.sleep(1000);
        System.out.println("main完成"+sum);
    }
}
