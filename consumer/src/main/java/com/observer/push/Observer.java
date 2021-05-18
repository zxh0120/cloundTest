package com.observer.push;

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
     * @param subject 更新的状态
     */
    void update(String subject);
}
