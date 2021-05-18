package com.design.factory.abstraction;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description  抽象工厂
 *              定义Ios工厂
 * @since 2021/3/18
 **/
public class IosFactory  implements SystemFactory{
    @Override
    public OperationController createOperationController() {
        return new IosOperationController();
    }

    @Override
    public UIController createUIController() {
        return new IosUIController();
    }
}
