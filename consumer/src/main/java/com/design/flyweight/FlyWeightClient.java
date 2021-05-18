package com.design.flyweight;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 享元模式
 * 客户端模式售卖书的过程
 * @since 2021/4/2
 **/
@Slf4j
public class FlyWeightClient {
    private static List<FlyWeight> orders = new ArrayList<>();
    private static FlyWeightFactory flyWeightFactory;

    public static void main(String[] args) {
        flyWeightFactory = FlyWeightFactory.getInstance();
        takeOrders("三国演义");
        takeOrders("水浒传");
        takeOrders("封神榜");
        takeOrders("三体");
        takeOrders("红楼梦");
        takeOrders("三国演义");
        takeOrders("封神榜");
        takeOrders("水浒传");
        for (FlyWeight order : orders) {
            order.sell();
        }
        // 打印生成的订单java对象数量
        log.info("\n客户一共买了 " + orders.size() + " 本书! ");
        // 打印生成的订单java对象数量
        log.info("共生成了 " + flyWeightFactory.getTotalObjects()
                + " 个 FlyWeight java对象! ");
    }

    private static void takeOrders(String bookName) {
        orders.add(flyWeightFactory.getOrder(bookName));
    }
}
