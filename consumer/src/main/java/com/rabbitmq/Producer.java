package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 * @since 2021/5/21
 **/
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setHost("192.168.3.23");
        //建立到代理服务器连接
        Connection connection = connectionFactory.newConnection();
        //获得信道
        Channel channel = connection.createChannel();
        //声明交换器
        String exchangeName="hello-exchange";
        channel.exchangeDeclare(exchangeName,"direct",true);
        String routingKey="hello";
        //发布消息
        byte [] messageBodyBytes="quit".getBytes();
        channel.basicPublish(exchangeName,routingKey,null,messageBodyBytes);
        channel.close();
        connection.close();

    }
}
