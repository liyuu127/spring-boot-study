package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "dispatcher_reconciliation")
public class DispatcherReconciliation implements Serializable {
    /**
     * 主健id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对账金额，单位分
     */
    @TableField(value = "pay_money")
    private Integer payMoney;

    /**
     * 账单状态（0-未出账单；1-已出未支付账单；2-已支付账单）
     */
    @TableField(value = "pay_status")
    private Short payStatus;

    /**
     * 商户名
     */
    @TableField(value = "merchant_name")
    private String merchantName;

    /**
     * 线路id
     */
    @TableField(value = "line_id")
    private Integer lineId;

    /**
     * 账单开始时间 （暂定）
     */
    @TableField(value = "bill_start_time")
    private Date billStartTime;

    /**
     * 账单结束时间  （暂定）
     */
    @TableField(value = "bill_end_time")
    private Date billEndTime;

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

    public static final String COL_PAY_MONEY = "pay_money";

    public static final String COL_PAY_STATUS = "pay_status";

    public static final String COL_MERCHANT_NAME = "merchant_name";

    public static final String COL_LINE_ID = "line_id";

    public static final String COL_BILL_START_TIME = "bill_start_time";

    public static final String COL_BILL_END_TIME = "bill_end_time";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}