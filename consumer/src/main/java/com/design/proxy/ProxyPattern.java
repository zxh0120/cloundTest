package com.design.proxy;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 代理模式
 * a.需求：
 * 背景：小明想买一台Mac电脑
 * 冲突：国内还没上，只有美国才有
 * 解决方案：寻找代购进行购买
 * 抽象：
 * 代购（代理对象）代替我（真实对象）去买 Mac(间接访问的操作
 * b. 使用步骤
 * 步骤1： 创建抽象对象接口（Subject）：声明你（真实对象）需要让代购（代理对象）帮忙做的事（买Mac）
 * 步骤2： 创建真实对象类（RealSubject）,即”我“
 * 步骤3： 创建代理对象类（Proxy），即”代购“，并通过代理类创建真实对象实例并访问其方法
 * 步骤4： 客户端调用
 * @since 2021/3/17
 **/
public class ProxyPattern {
    public static void main(String[] args) {
        Subject subject =new Proxy();
        subject.buyMac();
    }
}
