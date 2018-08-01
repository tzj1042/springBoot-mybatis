package com.example.demo.utils;

/**
 * 测试String
 *
 * @author tzj
 * @create 2018-07-31 11:39
 **/
public class TestString {

    static String storageAccountName="你是";
    static String storageAccountKey="🐖吗";

    public static void main(String[] args) {

        String connectionString = String.format(
                "DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.windows.net",
                storageAccountName, storageAccountKey);
        System.out.println(connectionString);
    }
}
