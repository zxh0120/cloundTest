package com.design.factory.abstraction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 抽象工厂
 *           Android具体操作控制器
 * @since 2021/3/18
 **/
@Slf4j
public class AndroidOperationController implements OperationController {
    @Override
    public void control() {
        log.info("AndroidOperationController");
    }
}
