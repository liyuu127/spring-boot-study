package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "sys_auth_ordinal")
public class SysAuthOrdinal implements Serializable {
    /**
     * 主键id
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 排序号
     */
    @TableField(value = "ordinal")
    private Integer ordinal;

    /**
     * 权限id
     */
    @TableField(value = "auth_id")
    private Integer authId;

    /**
     * 层级
     */
    @TableField(value = "level")
    private Integer level;

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
     * 是否已被删除(0-未删除；1-已删除)
     */
    @TableField(value = "deleted")
    private Byte deleted;

    private static final long serialVersionUID = 1L;

    public static final String COL_ORDINAL = "ordinal";

    public static final String COL_AUTH_ID = "auth_id";

    public static final String COL_LEVEL = "level";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}