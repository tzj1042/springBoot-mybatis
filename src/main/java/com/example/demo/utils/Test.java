package com.example.demo.utils;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author tzj
 * @create 2018-04-27 19:48
 **/
public class Test {

    static {
        System.out.println("我是静态取悦于QQQQQQQQQQQQ");
    }

    /**
     * 阿拉伯数字转罗马
     *
     * @param aNumber
     * @return
     */
    public static String numToRome(int aNumber) {
        if (aNumber < 1 || aNumber > 3999) {
            return "-1";
        }
        int[] aArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String rNumber = "";
        for (int i = 0; i < aArray.length; i++) {
            while (aNumber >= aArray[i]) {
                rNumber += rArray[i];
                aNumber -= aArray[i];
            }
        }
        return rNumber;
    }

    public static void main(String[] args) {
        System.out.println("转换后：" + numToRome(2018));

        String string = "fdfdfd";
        Runnable ran = () -> {
            System.out.println(string);
        };
        new Thread(ran).start();
        new Thread(() -> {
            System.out.println("11212");
        }).start();

        List<Integer> integers = Arrays.asList(3, 1, 2, 4, 6, 5);
        List<Integer> integers2=new ArrayList<>();
        Stream<Integer> stream = integers.stream();
        stream.sorted().forEach(s->{
            integers2.add(s);
            //System.out.println(s);
        });
        integers2.stream().forEach(x->{
            System.out.println("x = " + x);
        });
    }

}
