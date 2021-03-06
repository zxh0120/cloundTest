package com.design.singleton;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 单例模式
 *          饿汉式
 *  类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快。
 *  这种方式基于类加载机制避免了多线程的同步问题，但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 *  这时候初始化instance显然没有达到懒加载的效果
 * @since 2021/3/24
 **/
public class Hungry {
    private static Hungry hungry = new Hungry();
    private Hungry() {

    }
    public static Hungry getHungry() {
        return hungry;
    }
}
