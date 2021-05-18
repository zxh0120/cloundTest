package com.design.filter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 * @since 2021/3/30
 **/
@Slf4j
public class DebugFilter implements Filter {
    @Override
    public void execute(String request) {
        log.info("DebugFilter request: " + request);
    }
}
