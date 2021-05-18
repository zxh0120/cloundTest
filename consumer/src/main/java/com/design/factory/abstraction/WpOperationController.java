package com.design.factory.abstraction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description  抽象工厂
 *              wp具体WpUIController 操作控制器
 * @since 2021/3/18
 **/
@Slf4j
public class WpOperationController  implements OperationController{
    @Override
    public void control() {
        log.info("WpOperationController");
    }
}
