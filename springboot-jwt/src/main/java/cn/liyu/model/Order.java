package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "order")
public class Order implements Serializable {
    /**
     * 主健id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "passenger_id")
    private Integer passengerId;

    /**
     * 众筹id
     */
    @TableField(value = "crowd_funding_id")
    private Integer crowdFundingId;

    /**
     * 订单编号
     */
    @TableField(value = "order_number")
    private String orderNumber;

    /**
     * 用户电话号码
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 线路id
     */
    @TableField(value = "line_id")
    private Integer lineId;

    /**
     * 线路名
     */
    @TableField(value = "line_name")
    private String lineName;

    /**
     * 支付单号
     */
    @TableField(value = "pay_number")
    private String payNumber;

    /**
     * 支付平台单号(微信、支付宝等)
     */
    @TableField(value = "trade_no")
    private String tradeNo;

    /**
     * 支付金额，单位分
     */
    @TableField(value = "pay_money")
    private Integer payMoney;

    /**
     * 支付状态（0-未支付；1-已支付；2-支付失败）
     */
    @TableField(value = "pay_status")
    private Short payStatus;

    /**
     * 支付时间
     */
    @TableField(value = "pay_time")
    private Date payTime;

    /**
     * 备注，预留字段
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

    public static final String COL_PASSENGER_ID = "passenger_id";

    public static final String COL_CROWD_FUNDING_ID = "crowd_funding_id";

    public static final String COL_ORDER_NUMBER = "order_number";

    public static final String COL_PHONE_NUMBER = "phone_number";

    public static final String COL_LINE_ID = "line_id";

    public static final String COL_LINE_NAME = "line_name";

    public static final String COL_PAY_NUMBER = "pay_number";

    public static final String COL_TRADE_NO = "trade_no";

    public static final String COL_PAY_MONEY = "pay_money";

    public static final String COL_PAY_STATUS = "pay_status";

    public static final String COL_PAY_TIME = "pay_time";

    public static final String COL_REMARK = "remark";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}