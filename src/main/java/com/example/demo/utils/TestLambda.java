package com.example.demo.utils;

import javafx.print.Collation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试lambda表达式
 *
 * @author tzj
 * @create 2018-07-31 14:54
 *
 * a -> System.out.print(a) 等价于 System.out::print
 **/
public class TestLambda {

    //数字的排序(用到 .forEach .sort)
    static void ListIntSort(List<Integer> list){
        System.out.println("排序前：");
        list.forEach(a -> System.out.print(a));
        list.sort(
                (a,b) -> a - b
        );
        System.out.println("\n排序后：");
        list.forEach(a -> System.out.print(a));
    }

    //字符串的排序(用到 .forEach .sort)
    static void ListStringSort(List<String> list){
        System.out.println("排序前：");
        list.forEach(a -> System.out.print(a+","));
        list.sort(
                (a,b) -> a.compareTo(b)//按字符串排序
                //(a,b) -> a.length()-b.length()//按字符串长度排序
        );
        System.out.println("\n排序后：");
        list.forEach(a -> System.out.print(a+","));
    }

    //过滤(.stream().filter().collect())
    static void filter(List<String> strList){
        // 创建一个字符串列表，每个字符串长度大于2
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }

    //批量处理元素(.stream().map())
    static void ListIntAdd(List<Integer> list){
        System.out.println("处理前：");
        list.forEach(System.out::print);
        System.out.println("\n所有元素加一后：");
        list.stream().map(a->a+1).forEach(
                System.out::print
        );
    }

    //批量处理转换大小写(.stream().map().collect())
    static void toCase(List<String> list){
        System.out.println("处理前：");
        list.forEach(System.out::print);
        System.out.println("\n所有元素转换大写,并收集起来用&拼接：");
        String collect = list.stream().map(a -> a.toUpperCase()).collect(Collectors.joining("&"));
        System.out.println(collect);
    }

    //获取数字的个数、最小值、最大值、总和以及平均值 .stream().mapToInt().summaryStatistics()
    static void statistics(){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    //去重 用到（.distinct().collect()）
    static void distinct(){
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    //多线程
    static void manyThread(int i){
        new Thread(() -> System.out.println("It's a lambda function Thread!"+i)).start();

        Runnable runnable = () -> System.out.println("Runnable"+i);
        new Thread(runnable).start();
    }

    //map的作用是将一个对象变为另外一个，而reduce实现的则是将所有值合并为一个
    public void mapReduceTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double allCost = cost.stream().map(x -> x+x*0.05).reduce((sum,x) -> sum + x).get();
        System.out.println(allCost);
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(1);
        integers.add(2);
        integers.add(4);
        //ListIntSort(integers);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("adc");
        strings.add("ccad");
        strings.add("bdfgafdfdf");
        strings.add("dfdsdfefdsfdfdf");
        ListStringSort(strings);

        //ListIntAdd(integers);

        //toCase(strings);

        for (int i = 0; i < 3; i++) {
            manyThread(i);
        }
    }
}
