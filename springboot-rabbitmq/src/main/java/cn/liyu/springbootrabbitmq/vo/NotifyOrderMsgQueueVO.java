package cn.liyu.springbootrabbitmq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liyu
 * @date 2019/10/18 9:35
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyOrderMsgQueueVO implements Serializable {
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 支付宝交易号
     */
    private String tradeNo;
    /**
     * 交易状态
     */
    private String tradeStatus;
    /**
     * 付款金额
     */
    private String totalAmount;
}
