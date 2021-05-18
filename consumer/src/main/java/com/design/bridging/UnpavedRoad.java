package com.design.bridging;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 桥接模式
 * 具体的路
 * @since 2021/3/30
 **/
@Slf4j
public class UnpavedRoad extends Road {
    public UnpavedRoad(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void driveOnRoad() {
        super.vehicle.drive();
        log.info("行驶在石子路");
    }
}
