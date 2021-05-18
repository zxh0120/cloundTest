package com.design.factory.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 外观模式
 * 灯类
 * @since 2021/4/1
 **/
@Slf4j
public class SubSystemA_Light {
    public void on() {
        log.info("打开了灯。。。");
    }

    public void off() {
        log.info("关闭了灯。。。");
    }
}
