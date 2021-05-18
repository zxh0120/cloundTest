package com.design.flyweight;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 享元模式
 * 具体实现图书售卖的实现类
 * 具体享元类：实现抽象享元类的接口，完成某一具体逻辑。
 * @since 2021/4/2
 **/
@Slf4j
public class BookOrder implements FlyWeight {
    private String name;

    public BookOrder(String name) {
        this.name = name;
    }

    @Override
    public void sell() {
        log.info("卖了一本书，书名为'" + this.name + "'");
    }
}
