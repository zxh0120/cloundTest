package com.observer.pull;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 观察者模式
 * 　抽象观察者角色类
 * @since 2021/4/14
 **/
public interface Observer {

    /**
     * 更新接口
     *
     * @param subject 传入主题对象，方面获取相应的主题对象的状态
     */
    void update(Subject subject);
}
