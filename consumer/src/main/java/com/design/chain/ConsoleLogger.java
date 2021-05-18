package com.design.chain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 责任链模式
 * ConcreteHandler : 具体处理者，具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。
 * 创建扩展了该记录器类的实体类。
 * @since 2021/4/6
 **/
@Slf4j
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.info("Standard Console::Logger: " + message);
    }
}
