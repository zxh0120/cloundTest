package com.design.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 代理模式
 *              真实对象：代理对象所代表的真实对象，最终引用的对象
 * @since 2021/3/17
 **/
@Slf4j
public class RealSubject implements Subject {
    @Override
    public void buyMac() {
        log.info("买一台Mac");
    }
}
