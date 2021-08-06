package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "crowd_funding")
public class CrowdFunding implements Serializable {
    /**
     * 众筹表id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车队长id(乘客表主键)
     */
    @TableField(value = "passenger_id")
    private Integer passengerId;

    /**
     * 线路id
     */
    @TableField(value = "line_id")
    private Integer lineId;

    /**
     * 众筹单价，单位分(没人应付方案钱)
     */
    @TableField(value = "price")
    private Integer price;

    /**
     * 众筹单价，单位分(每人每日票价，预留)
     */
    @TableField(value = "ticket_price")
    private Integer ticketPrice;

    /**
     * 众筹完成目标人数
     */
    @TableField(value = "head_account")
    private Integer headAccount;

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

    public static final String COL_PASSENGER_ID = "passenger_id";

    public static final String COL_LINE_ID = "line_id";

    public static final String COL_PRICE = "price";

    public static final String COL_TICKET_PRICE = "ticket_price";

    public static final String COL_HEAD_ACCOUNT = "head_account";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_LINE_START_TIME = "line_start_time";

    public static final String COL_LINE_END_TIME = "line_end_time";

    public static final String COL_SCHEDULE_TIMES = "schedule_times";

    public static final String COL_BUS_LOAD = "bus_load";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}