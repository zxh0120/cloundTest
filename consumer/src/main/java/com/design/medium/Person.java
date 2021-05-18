package com.design.medium;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 中介模式
 * 抽象同事对象
 * @since 2021/4/13
 **/
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

}
