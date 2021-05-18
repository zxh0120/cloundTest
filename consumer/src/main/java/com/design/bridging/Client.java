package com.design.bridging;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 桥接模式
 * 客户端
 * @since 2021/3/30
 **/
public class Client {
    public static void main(String[] args) {
        Road road = new CementRoad(new Bus());
        road.driveOnRoad();
    }
}
