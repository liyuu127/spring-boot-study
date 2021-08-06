package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "sys_auth")
public class SysAuth implements Serializable {
    /**
     * 主键
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 权限uri
     */
    @TableField(value = "uri")
    private String uri;

    /**
     * 权限状态(0-停用，1-启用)
     */
    @TableField(value = "status")
    private Short status;

    /**
     * web路由名称
     */
    @TableField(value = "route_name")
    private String routeName;

    /**
     * 类型(1-功能，2-模块)
     */
    @TableField(value = "type")
    private Short type;

    /**
     * 功能操作类型（1-查找；2-新增；3-编辑；4-删除)
     */
    @TableField(value = "operate_type")
    private Short operateType;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;

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
     * 是否已被删除(0-未删除，1-已删除)
     */
    @TableField(value = "deleted")
    private Byte deleted;

    private static final long serialVersionUID = 1L;

    public static final String COL_NAME = "name";

    public static final String COL_URI = "uri";

    public static final String COL_STATUS = "status";

    public static final String COL_ROUTE_NAME = "route_name";

    public static final String COL_TYPE = "type";

    public static final String COL_OPERATE_TYPE = "operate_type";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}