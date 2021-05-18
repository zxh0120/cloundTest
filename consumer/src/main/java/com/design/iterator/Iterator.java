package com.design.iterator;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 迭代器模式
 * 抽象迭代器角色类
 * @since 2021/4/8
 **/
public interface Iterator {
    /**
     * 迭代方法：移动到第一个元素
     */
    void first();

    /**
     * 迭代方法：移动到下一个元素
     */
    void next();

    /**
     * 迭代方法：是否为最后一个元素
     */
    boolean isDone();

    /**
     * 迭代方法：返还当前元素
     */
    Object currentItem();
}
