package com.observer.pull;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 观察者模式
 * 抽象主题(Subject)角色
 * @since 2021/4/14
 **/
@Slf4j
public abstract class Subject {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> observerList = new ArrayList<>();


    /**
     * 注册观察者对象
     *
     * @param observer 观察者对象
     */
    public void attach(Observer observer) {
        observerList.add(observer);
        log.info("Attached an observer");
    }

    /**
     * 删除观察者对象
     *
     * @param observer 观察者对象
     */
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void nofifyObservers() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}
