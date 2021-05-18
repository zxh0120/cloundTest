package com.design.factory.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂模式
 * * 三角形  实现画图形Shape接口
 * @since 2021/3/17
 **/
@Slf4j
public class TriangleShape implements Shape {
    @Override
    public void draw() {
        log.info("draw:TriangleShape");
    }
}
