package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "passenger")
public class Passenger implements Serializable {
    /**
     * 主健id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电话号码
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 状态(0-禁用;1-使用中)
     */
    @TableField(value = "status")
    private Byte status;

    /**
     * 微信openId
     */
    @TableField(value = "wx_open_id")
    private String wxOpenId;

    /**
     * 乘客类型(0: 普通乘客;1- 车队长)
     */
    @TableField(value = "type")
    private Byte type;

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

    public static final String COL_STATUS = "status";

    public static final String COL_WX_OPEN_ID = "wx_open_id";

    public static final String COL_TYPE = "type";

    public static final String COL_LAST_LOGIN_TIME = "last_login_time";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}