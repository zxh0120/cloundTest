package com.design.factory.abstraction;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂模式
 *          定义抽象工厂
 * @since 2021/3/18
 **/
public interface SystemFactory  {
     OperationController createOperationController();
     UIController createUIController();
}
