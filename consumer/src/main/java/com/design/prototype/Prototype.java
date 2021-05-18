package com.design.prototype;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 原型模式
 * 抽象原型角色
 * @since 2021/3/25
 **/
public interface Prototype {
    /**
     * 克隆自身的方法
     *
     * @return 一个从自身克隆出来的对象
     */
    Object clone();

    String getName();

    void setName(String name);
}
