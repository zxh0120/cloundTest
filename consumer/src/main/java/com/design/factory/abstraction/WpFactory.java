package com.design.factory.abstraction;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description  抽象工厂
 *              定义Wp工厂
 * @since 2021/3/18
 **/
public class WpFactory implements SystemFactory{
    @Override
    public OperationController createOperationController() {
        return new WpOperationController();
    }

    @Override
    public UIController createUIController() {
        return new WpUIController();
    }
}
