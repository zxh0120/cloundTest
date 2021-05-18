package com.design.decorator;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 装饰器模式
 * <p>
 * 抽象装饰角色“七十二变”
 * 装饰（Decorator）角色：持有一个构件（Component）对象的实例，并定义一个与抽象构件接口一致的接口。
 * @since 2021/3/31
 **/
public class Change implements TheGreatestSage {

    private TheGreatestSage theGreatestSage;

    public Change(TheGreatestSage theGreatestSage) {
        this.theGreatestSage = theGreatestSage;
    }

    @Override
    public void move() {
        theGreatestSage.move();
    }
}
