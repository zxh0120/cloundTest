package com.design.factory.simple;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 简单工厂
 *              只通过给ShapeFactory传入不同的参数就实现了各种形状的绘制。以上就是简单工厂方式
 * @since 2021/3/17
            **/
    public class SimpleFactoryClient {
        public static void main(String[] args) {
            //画圆形
            Shape shape = ShapeFactory.getShape("circle");
            shape.draw();
            //正方形
            Shape shape1 = ShapeFactory.getShape("rect");
            shape1.draw();
            //画三角形
            Shape shape2 = ShapeFactory.getShape("triangle");
            shape2.draw();
        }
}
