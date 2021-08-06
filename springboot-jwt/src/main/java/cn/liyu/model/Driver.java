package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "driver")
public class Driver implements Serializable {
    /**
     * 主健
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电话号码
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 调度公司id
     */
    @TableField(value = "dispatch_center_id")
    private Integer dispatchCenterId;

    /**
     * 最近一次登陆时间
     */
    @TableField(value = "last_login_time")
    private Date lastLoginTime;

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

    public static final String COL_PHONE_NUMBER = "phone_number";

    public static final String COL_DISPATCH_CENTER_ID = "dispatch_center_id";

    public static final String COL_LAST_LOGIN_TIME = "last_login_time";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}