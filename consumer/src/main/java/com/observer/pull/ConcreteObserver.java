package com.observer.pull;


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
    public void update(Subject subject) {
        observerState = ((ConcreteSubject) subject).getState();
        log.info("观察者状态为:" + observerState);
    }
}
