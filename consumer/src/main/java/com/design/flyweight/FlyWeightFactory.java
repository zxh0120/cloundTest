package com.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 享元模式
 * 享元工厂
 * @since 2021/4/2
 **/
public class FlyWeightFactory {
    private Map<String, FlyWeight> bookPools = new HashMap<String, FlyWeight>();
    private static FlyWeightFactory factory = new FlyWeightFactory();

    public static FlyWeightFactory getInstance() {
        return factory;
    }

    //添加订单
    public FlyWeight getOrder(String bookName) {
        FlyWeight order = null;
        if (bookPools.containsKey(bookName)) {
            order = bookPools.get(bookName);
        } else {
            order = new BookOrder(bookName);
            bookPools.put(bookName, order);
        }
        return order;
    }

    public int getTotalObjects() {
        return bookPools.size();
    }
}
