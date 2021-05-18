package com.design.prototype;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 原型模式
 * 具体原型角色
 * @since 2021/3/25
 **/
public class ConcretePrototype2 implements Prototype {
    private String name;

    @Override
    public Object clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Prototype prototype = new ConcretePrototype2();
        prototype.setName(name);
        return prototype;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Now in Prototype2 , name = " + this.name;
    }
}
