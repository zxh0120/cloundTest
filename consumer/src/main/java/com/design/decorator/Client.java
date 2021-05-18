package com.design.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 装饰器模式
 * 孙悟空有七十二般变化，他的每一种变化都给他带来一种附加的本领。
 * 他变成鱼儿时，就可以水里游泳；他变成鸟儿时，就可以在天上飞行。
 * <p>
 * 本例中，Component的角色便是由大名鼎鼎的齐天大圣扮演；
 * ConcreteComponent的角色属于大圣的本尊，就是猢狲本人；
 * Decorator的角色由大圣的七十二变扮演。
 * ConcreteDecorator的角色就是鱼儿、鸟儿等七十二般变化。
 * @since 2021/4/1
 **/
@Slf4j
public class Client {
    public static void main(String[] args) {
        TheGreatestSage theGreatestSage = new Monkey();
        //第一种
        TheGreatestSage bird = new Bird(theGreatestSage);
        bird.move();

        log.info("----------------------");
        //第二种
        TheGreatestSage fish = new Fish(new Bird(theGreatestSage));
        fish.move();
    }
}
