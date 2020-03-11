package cn.liyu.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMQ配置方式
 */
@Configuration
public class RabbitMQConfig {
    /**
     * 添加支付异步通知交换机
     */
    public static final String EX_PAY_NOTIFY = "ex_pay_notify";

    /**
     * 支付状态异步通知消息队列
     */
    public static final String PAY_NOTIFY_STATUS = "pay_notify_status";

    /**
     * 支付状态异步通知路由key
     */
    public static final String PAY_NOTIFY_STATUS_KET = "payNotifyStatus";

    /**
     * 交换机配置
     *
     * @return the exchange
     */
    @Bean(EX_PAY_NOTIFY)
    public Exchange EX_DECLARE() {
        return ExchangeBuilder.directExchange(EX_PAY_NOTIFY).durable(true).build();
    }

    /**
     * 声明支付状态异步通知消息队列
     */
    @Bean(PAY_NOTIFY_STATUS)
    public Queue QUEUE_DECLARE() {
        Queue queue = new Queue(PAY_NOTIFY_STATUS, true, false, true);
        return queue;
    }

    /**
     * 绑定支付状态异步通知消息队列到交换机
     *
     * @param queue    the queue
     * @param exchange the exchange
     * @return the binding
     */
    @Bean
    public Binding binding_payNotify_process(@Qualifier(PAY_NOTIFY_STATUS) Queue queue, @Qualifier(EX_PAY_NOTIFY) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(PAY_NOTIFY_STATUS_KET).noargs();
    }

}
