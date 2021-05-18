package com.design.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 代理模式
 *      代理对象：包含对真实对象的引用从而操作真实主题对象，相当于对真实的对象进行封装
 * @since 2021/3/17
 **/
@Slf4j
public class Proxy implements Subject {
    @Override
    public void buyMac() {
        //引用并创建真实对象实例，即”我“
        RealSubject realSubject = new RealSubject();
        //调用真实对象的方法，进行代理购买Mac
        realSubject.buyMac();
        //代理对象额外做的操作
        this.WrapMac();
    }

    public void WrapMac() {
        log.info("用盒子包装好Mac");
    }
}
