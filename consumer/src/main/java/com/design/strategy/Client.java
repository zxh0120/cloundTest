package com.design.strategy;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 * @since 2021/4/13
 **/
public class Client {
    public static void main(String[] args) {
        //输了
        Context context =new Context(new ConcreteStrategyA());
        context.contextInterface();

        //赢了
        Context context1 =new Context(new ConcreateStrategyB());
        context1.contextInterface();
    }
}
