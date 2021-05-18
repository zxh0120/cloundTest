package com.observer.push;


import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 观察者模式
 * 　　具体观察者角色类
 * @since 2021/4/14
 **/
@Slf4j
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        log.info("状态为：" + observerState);
    }
}
