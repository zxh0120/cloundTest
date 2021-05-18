package com.design.bridging;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 桥接模式
 * 具体的交通工具（ConcreteImplementor）
 * @since 2021/3/30
 **/
@Slf4j
public class Car implements Vehicle {
    @Override
    public void drive() {
        log.info("小轿车");
    }
}
