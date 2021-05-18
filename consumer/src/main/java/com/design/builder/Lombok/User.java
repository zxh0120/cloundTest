package com.design.builder.Lombok;

import lombok.Builder;
import lombok.ToString;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 * @since 2021/3/25
 **/
@ToString
@Builder
public class User {
    private Integer id;
    private String name;
    private String address;

    public static void main(String[] args) {
        User user =User.builder().address("北京").id(1).name("zxh").build();
        System.out.println(user);
    }
}
