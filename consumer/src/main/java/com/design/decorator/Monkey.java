package com.design.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 装饰器模式
 * 具体构件（ConCreateComponet）角色:定义一个简要接受附加责任的类
 * 具体构件角色“大圣本尊”，猢狲类
 * @since 2021/3/31
 **/
@Slf4j
public class Monkey implements TheGreatestSage {
    @Override
    public void move() {
        log.info("Monkey move");
    }
}
