package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "message")
public class Message implements Serializable {
    /**
     * 消息表主键
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对象表主键
     */
    @TableField(value = "contact_id")
    private Integer contactId;

    /**
     * 消息归属对象类型(1-乘客;2-司机;3-调度端用户;4-商家)
     */
    @TableField(value = "type")
    private Byte type;

    /**
     * 消息内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 是否已读(0-未读;1-已读)
     */
    @TableField(value = "read")
    private Byte read;

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

    public static final String COL_CONTACT_ID = "contact_id";

    public static final String COL_TYPE = "type";

    public static final String COL_CONTENT = "content";

    public static final String COL_READ = "read";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}