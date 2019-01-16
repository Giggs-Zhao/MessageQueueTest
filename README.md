# 各类消息队列结合SpringBoot学习

#### 项目介绍
主要是学习 消息队列
以下是学习汇总文章

#### 软件架构
软件架构说明


#### 安装教程

1. 根据git-url进行Clone
2. 导入对应模块

#### 使用说明
MessageQueue父模块
暂无专门测试模块


1. RabbitMQ
    最简单版本的Rabbit使用
2. RabbitMQ1
    fanout广播模式，只要跟它绑定的队列都会通知并且接受到消息，基于上边第1点
3. RabbitMQ2
    topic，topic队列跟交换器，消费者只会接收指定的消息，基于上边第2点
4. RabbitMQ3
    Direct模式，相对topic要严格，绑定时给入key，只让符合key的接收者接收，基于第1点
5. RabbitMQ4
    Delay模式，延期消息队列，将队列放入Enum中，另外在MQ3的POM引入MQ4依赖，并清空MQ内的队列（连接15762接口），先启动MQ4测试方法，发送消息，然后启动MQ3，启动马上读取，或者先启动MQ3，再启动MQ4测试方法（要快，不然MQ3报错），10秒后可以看到新的消息
    
    
    基于第1点

#### 参与贡献

1. RyzeZhao

#### MessageQueue消息队列博客汇总