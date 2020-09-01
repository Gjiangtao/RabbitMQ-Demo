package com.test.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MyProducer {
    static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 主机地址：默认为localhost
        connectionFactory.setHost("172.21.2.107");
        // 连接端口
        connectionFactory.setPort(5672);
        // 虚拟主机名称：默认为 / 相当于一个数据库
        connectionFactory.setVirtualHost("/unionpay");
        // 连接用户名：默认为guest
        connectionFactory.setUsername("root");
        // 连接密码：默认为guest
        connectionFactory.setPassword("root");
        // 创建连接，一个连接可以有多个频道
        Connection connection = connectionFactory.newConnection();
        // 创建频道
        Channel channel = connection.createChannel();
        /**
         * 声明（创建）队列
         * params：
         * 1、队列名称
         * 2、是否定义持久化队列
         * 3、是否独占本次连接
         * 4、是否在不使用的时候自动删除队列
         * 5、队列其他参数
         */
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        // 要发送的消息
        String message = "Hello World";
        channel.basicPublish("", QUEUE_NAME,null,message.getBytes());
        System.out.println("已发送消息" + message);
        // 释放资源
        channel.close();
        connection.close();
    }

}
