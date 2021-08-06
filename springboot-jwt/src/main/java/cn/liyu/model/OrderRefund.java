package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "order_refund")
public class OrderRefund implements Serializable {
    /**
     * 退款表主键
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单表主键
     */
    @TableField(value = "order_id")
    private Integer orderId;

    /**
     * 退款状态（1-待退款;2-退款中;3-退款完成;4-退款失败;5-待重试）
     */
    @TableField(value = "refund_status")
    private Short refundStatus;

    /**
     * 退款金额
     */
    @TableField(value = "refund_money")
    private Integer refundMoney;

    /**
     * 退款时间
     */
    @TableField(value = "refund_time")
    private Date refundTime;

    /**
     * 退款信息
     */
    @TableField(value = "refund_msg")
    private String refundMsg;

    /**
     * 退款单号
     */
    @TableField(value = "refund_number")
    private String refundNumber;

    /**
     * 支付平台退款单号
     */
    @TableField(value = "refund_trade_no")
    private String refundTradeNo;

    /**
     * 手续费
     */
    @TableField(value = "service_money")
    private Integer serviceMoney;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    /**
     * 是否已被删除（0-未删除；1-已删除）
     */
    @TableField(value = "deleted")
    private Byte deleted;

    private static final long serialVersionUID = 1L;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_REFUND_STATUS = "refund_status";

    public static final String COL_REFUND_MONEY = "refund_money";

    public static final String COL_REFUND_TIME = "refund_time";

    public static final String COL_REFUND_MSG = "refund_msg";

    public static final String COL_REFUND_NUMBER = "refund_number";

    public static final String COL_REFUND_TRADE_NO = "refund_trade_no";

    public static final String COL_SERVICE_MONEY = "service_money";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}