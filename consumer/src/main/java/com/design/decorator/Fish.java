package com.design.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 装饰器模式
 * 具体装饰角色，“鱼儿”
 * 具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。
 * @since 2021/3/31
 **/
@Slf4j
public class Fish extends Change {

    public Fish(TheGreatestSage theGreatestSage) {
        super(theGreatestSage);
    }

    @Override
    public void move() {
        super.move();
        log.info("Change fish move");
    }

}
