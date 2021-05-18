package com.design.strategy;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 策略模式
 * 封装角色
 * @since 2021/4/13
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 调用策略
     */
    public void contextInterface() {
        strategy.algorithmLogic();
    }
}
