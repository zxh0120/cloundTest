package com.design.factory.facade;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 外观模式
 * 小成买了一个智能家具控制器（外观对象/统一接口）给他爷爷，他爷爷只需要一键就能打开/关闭 灯、电视机、空调
 * <p>
 * 1.即用外观模式来为所有子系统设计一个统一的接口
 * 2.客户端只需要调用外观类中的方法就可以了，简化了客户端的操作
 * @since 2021/4/1
 **/
public class Facade {
    SubSystemA_Light subSystemA_light;
    SubSystemB_Television subSystemB_television;
    SubSystemC_Aircondition subSystemC_aircondition;

    public Facade(SubSystemA_Light subSystemA_light, SubSystemB_Television subSystemB_television,
                  SubSystemC_Aircondition subSystemC_aircondition) {
        this.subSystemA_light = subSystemA_light;
        this.subSystemC_aircondition = subSystemC_aircondition;
        this.subSystemB_television = subSystemB_television;
    }

    //起床后一键开电器
    public void on() {
        subSystemA_light.on();
        subSystemB_television.on();
        subSystemC_aircondition.on();
    }

    //睡觉时一键关电器
    public void off() {
        subSystemA_light.off();
        subSystemB_television.off();
        subSystemC_aircondition.off();
    }


}
