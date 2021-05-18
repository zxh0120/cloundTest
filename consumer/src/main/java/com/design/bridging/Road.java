package com.design.bridging;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 桥接模式
 * 抽象的路（Abstraction）
 * @since 2021/3/30
 **/
public abstract class Road {
    protected Vehicle vehicle;

    public Road(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract void driveOnRoad();
}
