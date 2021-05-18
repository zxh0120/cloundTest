package com.design.factory.abstraction;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 抽象工厂
 *            Android工厂
 * @since 2021/3/18
 **/
public class AndroidFactory  implements SystemFactory{
    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }
    @Override
    public UIController createUIController() {
        return new AndroidUIController();
    }
}
