package com.design.factory.method;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂方法模式
 *              JPG图片加载器
 * @since 2021/3/17
 **/
@Slf4j
public class JpgReader implements Reader {
    @Override
    public void read() {
        log.info("JpgReader : Reader");
    }
}
