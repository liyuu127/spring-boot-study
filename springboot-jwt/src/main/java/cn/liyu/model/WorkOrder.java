package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "work_order")
public class WorkOrder implements Serializable {
    /**
     * 工单表主键
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 司机id
     */
    @TableField(value = "driver_id")
    private Integer driverId;

    /**
     * 车辆id
     */
    @TableField(value = "vehicle_id")
    private Integer vehicleId;

    /**
     * 车牌号
     */
    @TableField(value = "vehicle_number")
    private String vehicleNumber;

    /**
     * 实际发车时间
     */
    @TableField(value = "real_start_time")
    private Date realStartTime;

    /**
     * 预计发车时间
     */
    @TableField(value = "predict_start_time")
    private Date predictStartTime;

    /**
     * 实际结束时间
     */
    @TableField(value = "real_end_time")
    private Date realEndTime;

    /**
     * 状态(0:待发车;1:运行中;2:正常结束;3:异常结束;4:停班）
     */
    @TableField(value = "status")
    private Short status;

    /**
     * 异常状态（0-正常，1-异常）
     */
    @TableField(value = "error_status")
    private Short errorStatus;

    /**
     * 异常信息
     */
    @TableField(value = "error_info")
    private String errorInfo;

    /**
     * 发车时刻表id
     */
    @TableField(value = "vehicle_plan_id")
    private Integer vehiclePlanId;

    /**
     * 发车站点id
     */
    @TableField(value = "start_station_id")
    private Integer startStationId;

    /**
     * 发车站点名称
     */
    @TableField(value = "start_station_name")
    private String startStationName;

    /**
     * 终点站id
     */
    @TableField(value = "end_station_id")
    private Integer endStationId;

    /**
     * 终点站名称
     */
    @TableField(value = "end_station_name")
    private String endStationName;

    /**
     * 商户id
     */
    @TableField(value = "merchant_id")
    private Integer merchantId;

    /**
     * 首次到达首发站时间
     */
    @TableField(value = "first_arrive_time")
    private Date firstArriveTime;

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

    public static final String COL_LINE_ID = "line_id";

    public static final String COL_LINE_NAME = "line_name";

    public static final String COL_DRIVER_ID = "driver_id";

    public static final String COL_VEHICLE_ID = "vehicle_id";

    public static final String COL_VEHICLE_NUMBER = "vehicle_number";

    public static final String COL_REAL_START_TIME = "real_start_time";

    public static final String COL_PREDICT_START_TIME = "predict_start_time";

    public static final String COL_REAL_END_TIME = "real_end_time";

    public static final String COL_STATUS = "status";

    public static final String COL_ERROR_STATUS = "error_status";

    public static final String COL_ERROR_INFO = "error_info";

    public static final String COL_VEHICLE_PLAN_ID = "vehicle_plan_id";

    public static final String COL_START_STATION_ID = "start_station_id";

    public static final String COL_START_STATION_NAME = "start_station_name";

    public static final String COL_END_STATION_ID = "end_station_id";

    public static final String COL_END_STATION_NAME = "end_station_name";

    public static final String COL_MERCHANT_ID = "merchant_id";

    public static final String COL_FIRST_ARRIVE_TIME = "first_arrive_time";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}