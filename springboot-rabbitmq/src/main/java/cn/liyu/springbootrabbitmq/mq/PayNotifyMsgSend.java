package cn.liyu.springbootrabbitmq.mq;

import cn.liyu.springbootrabbitmq.config.RabbitMQConfig;
import cn.liyu.springbootrabbitmq.vo.NotifyOrderMsgQueueVO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liyu
 * @date 2019/10/18 9:58
 * @description 接收支付状态消息
 */
@Component
public class PayNotifyMsgSend {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitMQConfig.PAY_NOTIFY_STATUS)
    public void receivePayNotifyMsg(NotifyOrderMsgQueueVO notifyOrderMsgQueueVO) {
        //TODO 更新支付状态
        System.out.println("notifyOrderMsgQueueVO = " + notifyOrderMsgQueueVO);
    }
}
