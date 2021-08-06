package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "merchant_line_scheme")
public class MerchantLineScheme implements Serializable {
    /**
     * 商家线路方案表id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 众筹单价，单位分
     */
    @TableField(value = "price")
    private Integer price;

    /**
     * 商户id
     */
    @TableField(value = "merchant_id")
    private Integer merchantId;

    /**
     * 线路id
     */
    @TableField(value = "line_id")
    private Integer lineId;

    /**
     * 趟次
     */
    @TableField(value = "schedule_times")
    private Integer scheduleTimes;

    /**
     * 载客量要求
     */
    @TableField(value = "bus_load")
    private Integer busLoad;

    /**
     * 众筹开始时间
     */
    @TableField(value = "start_time")
    private Date startTime;

    /**
     * 众筹截止时间
     */
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 线路开始运营时间
     */
    @TableField(value = "line_start_time")
    private Date lineStartTime;

    /**
     * 线路截止运营时间
     */
    @TableField(value = "line_end_time")
    private Date lineEndTime;

    /**
     * 0-未开始，1-进行中，2-已成功，3-已失败
     */
    @TableField(value = "status")
    private Byte status;

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

    public static final String COL_PRICE = "price";

    public static final String COL_MERCHANT_ID = "merchant_id";

    public static final String COL_LINE_ID = "line_id";

    public static final String COL_SCHEDULE_TIMES = "schedule_times";

    public static final String COL_BUS_LOAD = "bus_load";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_LINE_START_TIME = "line_start_time";

    public static final String COL_LINE_END_TIME = "line_end_time";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}