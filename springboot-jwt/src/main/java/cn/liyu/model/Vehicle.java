package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "vehicle")
public class Vehicle implements Serializable {
    /**
     * 主健
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车牌号
     */
    @TableField(value = "vehicle_number")
    private String vehicleNumber;

    /**
     * 状态（0-禁用;1-使用中）
     */
    @TableField(value = "status")
    private Short status;

    /**
     * 线路id
     */
    @TableField(value = "line_id")
    private Integer lineId;

    /**
     * 车辆类型id
     */
    @TableField(value = "vehicle_type_id")
    private Integer vehicleTypeId;

    /**
     * 调度中心id
     */
    @TableField(value = "dispatch_center_id")
    private Integer dispatchCenterId;

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

    public static final String COL_VEHICLE_NUMBER = "vehicle_number";

    public static final String COL_STATUS = "status";

    public static final String COL_LINE_ID = "line_id";

    public static final String COL_VEHICLE_TYPE_ID = "vehicle_type_id";

    public static final String COL_DISPATCH_CENTER_ID = "dispatch_center_id";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}