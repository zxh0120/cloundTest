package com.controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Test  extends HandlerInterceptorAdapter {

    public static void main(String[] args) {
        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();
        // 添加Key为name的
        stringMultiValueMap.add("name", "yolanda");
        stringMultiValueMap.add("name", "yanzhenjie");
        stringMultiValueMap.add("name", "yanzhenjie");
        stringMultiValueMap.add("name", "尤兰达");
        // 添加Key为domain的
        stringMultiValueMap.add("domain", "http://www.yanzhenjie.com");
        stringMultiValueMap.add("domain", "http://www.nohttp.net");

        // 拿到某个key的某个值
        System.out.println("name的第三个值：" + stringMultiValueMap.get("name"));

        // 打印所有值
//        Set<String> keySet = stringMultiValueMap.keySet();
//        for (String key : keySet) {
//            List<String> values = stringMultiValueMap.getValues(key);
//            for (String value : values) {
//                System.out.println(key + ": " + value);
//            }
    }
}
