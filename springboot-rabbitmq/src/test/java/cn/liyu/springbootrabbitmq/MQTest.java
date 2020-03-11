package cn.liyu.springbootrabbitmq;

import cn.liyu.springbootrabbitmq.config.RabbitMQConfig;
import cn.liyu.springbootrabbitmq.constant.RabbitBeanInfo;
import cn.liyu.springbootrabbitmq.constant.RabbitInfo;
import cn.liyu.springbootrabbitmq.mq.RabbitmqProducer;
import cn.liyu.springbootrabbitmq.vo.NotifyOrderMsgQueueVO;
import cn.liyu.springbootrabbitmq.vo.Programmer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * @date 2019/10/18 9:38
 * @description 消息队列测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MQTest {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitmqProducer producer;

    /**
     * 测试简单的消息发送
     */
    @Test
    public void MQSendTest() {
        NotifyOrderMsgQueueVO notifyOrderMsgQueueVO = new NotifyOrderMsgQueueVO();
        notifyOrderMsgQueueVO.setOutTradeNo("1234455678");
        notifyOrderMsgQueueVO.setTradeNo("123234444");
        notifyOrderMsgQueueVO.setTradeStatus("TRADE_FINISHED");
        notifyOrderMsgQueueVO.setTotalAmount("21.00");

        rabbitTemplate.convertAndSend(RabbitMQConfig.EX_PAY_NOTIFY, RabbitMQConfig.PAY_NOTIFY_STATUS_KET, notifyOrderMsgQueueVO);
    }

    /***
     * 发送消息体为简单数据类型的消息
     */
    @Test
    public void send() {
        Map<String, Object> heads = new HashMap<>();
        heads.put("msgInfo", "自定义消息头信息");
        // 模拟生成消息ID,在实际中应该是全局唯一的 消息不可达时候可以在setConfirmCallback回调中取得，可以进行对应的重发或错误处理
        String id = String.valueOf(Math.round(Math.random() * 10000));
        producer.sendSimpleMessage(heads, "hello Spring", id, RabbitInfo.EXCHANGE_NAME, "springboot.simple.abc");
    }

    /***
     * 发送消息体为bean的消息
     */
    @Test
    public void sendBean() {
        String id = String.valueOf(Math.round(Math.random() * 10000));
        Programmer programmer = new Programmer("xiaoMing", 12, 12123.45f, new Date());
        producer.sendSimpleMessage(null, programmer, id, RabbitBeanInfo.EXCHANGE_NAME, RabbitBeanInfo.ROUTING_KEY);
    }
}
