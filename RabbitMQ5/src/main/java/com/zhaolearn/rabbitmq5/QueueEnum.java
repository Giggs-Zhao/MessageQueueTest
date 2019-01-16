package com.zhaolearn.rabbitmq5;

public enum QueueEnum {
    /**
     * 消息通知队列
     */
    MESSAGE_QUEUE("message.center.create","message.center.direct","message.center.create"),
    /**
     * 消息通知ttl队列
     */
    MESSAGE_TTL_QUEUE("message.center.create.ttl","message.center.direct.ttl", "message.center.create.ttl");



    /**
     * 队列名称
     */
    private String queueName;
    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String queueName, String exchange, String routeKey) {
        this.queueName = queueName;
        this.exchange = exchange;
        this.routeKey = routeKey;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
