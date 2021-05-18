package com.design.bridging;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 桥接模式
 * 交通工具（Implementor）
 * 交通工具在路上行驶，这里有两个维度的变化，首先交通工具的类型不同，其次路也分水泥路和柏油路。
 * @since 2021/3/30
 **/
public interface Vehicle {
    void drive();
}
