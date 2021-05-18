package com.design.factory.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 小成爷爷使用电器情况
 * 案例： 小成的爷爷已经80岁了，一个人在家生活：每次都需要打开灯、打开电视、打开空调；睡觉时关闭灯、关闭电视、关闭空调
 * 冲突： 行动不方便，走过去关闭那么多电器很麻烦
 * @since 2021/4/1
 **/
@Slf4j
public class Client {
    public static void main(String[] args) {
        SubSystemA_Light subSystemA_light = new SubSystemA_Light();
        SubSystemB_Television subSystemB_television = new SubSystemB_Television();
        SubSystemC_Aircondition systemC_aircondition = new SubSystemC_Aircondition();

        log.info("起床后开电器。。。");
        subSystemA_light.on();
        subSystemB_television.on();
        systemC_aircondition.on();

        log.info("睡觉后关电器。。。");
        subSystemA_light.off();
        subSystemB_television.off();
        systemC_aircondition.off();
    }
}
