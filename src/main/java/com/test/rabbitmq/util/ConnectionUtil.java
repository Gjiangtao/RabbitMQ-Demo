package com.test.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
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

        // 创建连接
        Connection connection = connectionFactory.newConnection();
        return connection;
    }
}
