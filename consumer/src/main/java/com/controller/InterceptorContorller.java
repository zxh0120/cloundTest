package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class InterceptorContorller {

    @GetMapping(value = "/test/interceptor/{name}")
    public String interceptor(@PathVariable("name") String name) {
        log.info("执行方法：/test/interceptor---------");
        return "ok";
    }

    @GetMapping(value = "/test/noInterceptor/{name}")
    public void noInterception(@PathVariable("name") String name) {
        log.info("/test/noInterception--------");
    }
}
