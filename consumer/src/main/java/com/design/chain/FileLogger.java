package com.design.chain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 责任链模式
 * @since 2021/4/6
 **/
@Slf4j
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.info("File::Logger: " + message);
    }
}
