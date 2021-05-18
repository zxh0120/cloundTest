package com.design.factory.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 外观模式
 * @since 2021/4/1
 **/
@Slf4j
public class FacadePattern {
    public static void main(String[] args) {
        //实例化电器类
        SubSystemA_Light subSystemA_light = new SubSystemA_Light();
        SubSystemB_Television subSystemB_television = new SubSystemB_Television();
        SubSystemC_Aircondition systemC_aircondition = new SubSystemC_Aircondition();

        //传参
        Facade facade = new Facade(subSystemA_light, subSystemB_television, systemC_aircondition);
        //客户端直接与外观对象进行交互
        facade.on();
        log.info("可以看电视了");
        facade.off();
        log.info("可以睡觉了");

    }
}
