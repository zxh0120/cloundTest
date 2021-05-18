package com.design.compose;

import lombok.Data;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 组合模式
 * Component ：组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。声明一个接口用于访问和管理Component子部件。
 * @since 2021/3/31
 **/
@Data
public abstract class CustomizeFile {
    String name;

    public CustomizeFile(String name) {
        this.name = name;
    }

    public abstract void display();
}
