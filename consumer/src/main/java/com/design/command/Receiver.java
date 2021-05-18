package com.design.command;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 命令模式
 * 接收者角色类
 * @since 2021/4/7
 **/
@Slf4j
public class Receiver {

    /**
     * 真正执行命令相应的操作
     */
    public void action() {
        log.info("执行操作");
    }
}
