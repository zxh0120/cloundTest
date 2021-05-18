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
public class CementRoad extends Road {

    public CementRoad(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void driveOnRoad() {
        super.vehicle.drive();
        log.info("行驶在水泥路");
    }
}
