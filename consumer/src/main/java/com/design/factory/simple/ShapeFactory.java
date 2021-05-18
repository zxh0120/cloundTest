package com.design.factory.simple;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂模式
 *              通过传入不同的type可以new不同的形状，返回结果为Shape 类型，这个就是简单工厂核心的地方了。
 * @since 2021/3/17
 **/
public class ShapeFactory {

    public static Shape getShape(String type) {
        Shape shape = null;
        if (type.equalsIgnoreCase("circle")) {
            shape = new CircleShape();
        } else if (type.equalsIgnoreCase("rect")) {
            shape = new RectShape();
        } else if (type.equalsIgnoreCase("triangle")) {
            shape = new TriangleShape();
        }
        return shape;
    }


}
