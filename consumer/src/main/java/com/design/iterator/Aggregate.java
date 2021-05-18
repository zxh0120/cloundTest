package com.design.iterator;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 迭代器模式
 * @since 2021/4/8
 **/
public abstract class Aggregate {
    /**
     * 工厂方法，创建相应迭代子对象的接口
     */
    public  abstract Iterator createIterator();
}
