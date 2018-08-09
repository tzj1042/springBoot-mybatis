package com.example.demo.utils;

import java.math.BigDecimal;

/**
 * 测试计算
 *
 * @author tzj
 * @create 2018-07-20 16:33
 **/
public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal("2");
        BigDecimal b=new BigDecimal("27");
        System.out.println("a+b="+a.add(b));
        System.out.println("a-b="+a.subtract(b));
        System.out.println("a*b="+a.multiply(b));

        System.out.println("a/b="+a.divide(b,2,BigDecimal.ROUND_HALF_UP));
        //保留两位小数
        a=a.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(a.intValue());
        /*setScale(1)表示保留一位小数，默认用四舍五入方式
        setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3
        setScale(1,BigDecimal.ROUND_UP)进位处理，2.35变成2.4
        setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
        setScaler(1,BigDecimal.ROUND_HALF_DOWN)四舍五入，2.35变成2.3，如果是5则向下舍
        setScaler(1,BigDecimal.ROUND_CEILING)接近正无穷大的舍入
        setScaler(1,BigDecimal.ROUND_FLOOR)接近负无穷大的舍入，数字>0和ROUND_UP作用一样，数字<0和ROUND_DOWN作用一样
        setScaler(1,BigDecimal.ROUND_HALF_EVEN)向最接近的数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。*/

        //null参与运算报错java.lang.NullPointerException
        //BigDecimal c = BigDecimal.ZERO;
       // BigDecimal d =null;
        //System.out.println("测试："+d.add(c));

        System.out.println("测试！！");
        BigDecimal payGiveMoney=new BigDecimal("4.0");
        BigDecimal payMoney=new BigDecimal("0.00");
        BigDecimal totalMoney=new BigDecimal("3.0");
        if (payGiveMoney.add(payMoney).compareTo(totalMoney) < 0){
            System.out.println("小于返回！！");
        }else {
            System.out.println("大于继续！");
        }
    }
}
