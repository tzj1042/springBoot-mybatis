package com.example.demo.utils;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * list分页测试
 *
 * @author tzj
 * @create 2018-08-08 9:46
 **/
public class ListPageTest {

    public static void main(String[] args) {
        long front=System.currentTimeMillis();
        int pageNumber=1;
        int pageSize=10;
        List<String> list = new ArrayList<>();
        for (int i = 10; i>0 ; i--) {
            list.add(i+"");
        }
        System.out.println("分页前"+list.size());
        List<String> listPage = new ArrayList<>();
        int currIdx = (pageNumber > 1 ? (pageNumber -1) * pageSize : 0);
        System.out.println("currIdx："+currIdx);
        for (int i = 0; i < pageSize && i < list.size() - currIdx; i++) {
            String string = list.get(currIdx + i);
            listPage.add(string);
        }
        listPage.sort((a,b) -> a.compareTo(b));
        System.out.println("排序后"+listPage);
        double pa=(double)list.size()/pageSize;
        System.out.println((int)Math.ceil(pa));

        System.out.println(System.currentTimeMillis()-front+"ms");
        System.out.println("前:"+list);
        int pageStart=pageNumber==1?0:(pageNumber-1)*pageSize;
        int pageEnd=list.size()<pageNumber*pageSize?list.size():pageNumber*pageSize;
            System.out.println("开始:"+pageStart);
            System.out.println("结束:"+pageEnd);
            if (list.size()>pageStart){
                List<String> listPage2 = list.subList(pageStart>list.size()?list.size():pageStart, pageEnd);
                System.out.println("后1:"+ listPage2);
            }

    }
}
