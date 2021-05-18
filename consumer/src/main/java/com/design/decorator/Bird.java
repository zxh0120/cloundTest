package com.design.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 装饰器模式
 * 具体装饰角色，“鸟儿”
 * 具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。
 * @since 2021/4/1
 **/
@Slf4j
public class Bird extends Change {
    public Bird(TheGreatestSage theGreatestSage) {
        super(theGreatestSage);
    }

    @Override
    public void move() {
        super.move();
        log.info("Change bird move");
    }
}
