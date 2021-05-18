package com.design.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 * @since 2021/4/13
 **/
@Slf4j
public class ConcreteClass_BaoCai  extends Abstract {
    @Override
    void pourVegetable() {
    log.info("下锅的蔬菜是包菜");
    }

    @Override
    void pourSauce() {
        log.info("下锅的酱料是辣椒");

    }
}
