package com.design.factory.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 外观模式
 * 空调类
 * @since 2021/4/1
 **/
@Slf4j
public class SubSystemC_Aircondition {
    public void on() {
        log.info("打开了空调");
    }

    public void off() {
        log.info("关闭了空调");
    }
}
