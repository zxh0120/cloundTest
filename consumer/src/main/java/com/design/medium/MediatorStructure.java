package com.design.medium;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 中介模式
 * 具体中介者对象：中介结构
 * @since 2021/4/13
 **/
public class MediatorStructure extends Mediator {
    //首先中介结构必须知道所有房主和租房者的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Tenant tenant() {
        return tenant;
    }

    @Override
    public void constact(String message, Person person) {
        //如果是房主，则租房者获得信息
        if (person == houseOwner) {
            tenant.getMessage(message);
        } else {
            //反正则是房主获得信息
            houseOwner.getMessage(message);
        }
    }
}
