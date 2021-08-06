package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "line")
public class Line implements Serializable {
    /**
     * 主健
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 线路名
     */
    @TableField(value = "line_name")
    private String lineName;

    /**
     * 企业专线-商户id; 众筹线路-乘客id
     */
    @TableField(value = "merchant_id")
    private Integer merchantId;

    /**
     * 线路类型(1-企业专线;2-众筹线路)
     */
    @TableField(value = "type")
    private Byte type;

    /**
     * 0-未开始，1-进行中，2-已结束
     */
    @TableField(value = "status")
    private Byte status;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 创建时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    /**
     * 是否已被删除（0-未删除；1-已删除）
     */
    @TableField(value = "deleted")
    private Byte deleted;

    private static final long serialVersionUID = 1L;

    public static final String COL_LINE_NAME = "line_name";

    public static final String COL_MERCHANT_ID = "merchant_id";

    public static final String COL_TYPE = "type";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}