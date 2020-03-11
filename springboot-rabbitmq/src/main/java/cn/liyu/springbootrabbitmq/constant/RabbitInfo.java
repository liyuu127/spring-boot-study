package cn.liyu.springbootrabbitmq.constant;

/**
 * @author liyu
 * @date 2020/3/11 16:34
 * @description rabbit 公用配置信息
 */
public class RabbitInfo {
    // queue 配置
    public static final String QUEUE_NAME = "spring.boot.simple.queue";
    public static final String QUEUE_DURABLE = "true";

    // exchange 配置
    public static final String EXCHANGE_NAME = "spring.boot.simple.exchange";
    public static final String EXCHANGE_TYPE = "topic";

    // routing key
    public static final String ROUTING_KEY = "springboot.simple.*";
}
