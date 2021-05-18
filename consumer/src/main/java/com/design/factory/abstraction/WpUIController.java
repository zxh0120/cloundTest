package com.design.factory.abstraction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂模式
 *          Wp界面控制器
 * @since 2021/3/18
 **/
@Slf4j
public class WpUIController implements UIController {
    @Override
    public void display() {
      log.info("WpUIController");
    }
}
