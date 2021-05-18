package com.design.factory.method;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂方法模式
 *              Gif图片加载器
 * @since 2021/3/17
 **/
@Slf4j
public  class GifReader implements Reader {
    @Override
    public void read() {
        log.info("GifReader : Reader");
    }
}
