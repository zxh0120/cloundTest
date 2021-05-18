package com.design.adapter;

/**
 * @author zhouxiaohui
 * @blame Lanxum 适配器模式
 * @Description 类的适配器模式
 * @since 2021/3/26
 **/
public interface Target {
    //将220V转换输出110V（原有插头（Adaptee）没有的）
    void Convert_110v();
}
