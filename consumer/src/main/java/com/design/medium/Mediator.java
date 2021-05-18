package com.design.medium;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 中介模式
 * 抽象中介者
 * @since 2021/4/13
 **/
public abstract class Mediator {
    //申明一个联络方法
    public abstract void constact(String message, Person person);
}
