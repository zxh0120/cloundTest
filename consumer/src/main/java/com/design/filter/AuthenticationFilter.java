package com.design.filter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 过滤器模式
 * 具体的filter
 * @since 2021/3/30
 **/
@Slf4j
public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        log.info("Authenticating request: " + request);
    }
}
