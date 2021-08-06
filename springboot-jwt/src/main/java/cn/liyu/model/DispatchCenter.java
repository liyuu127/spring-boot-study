package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "dispatch_center")
public class DispatchCenter implements Serializable {
    /**
     * 调度中心表主健
     */
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 联系人
     */
    @TableField(value = "contact")
    private String contact;

    /**
     * 联系人电话号码
     */
    @TableField(value = "contact_phone")
    private String contactPhone;

    /**
     * 营业执照地址
     */
    @TableField(value = "url")
    private String url;

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

    public static final String COL_NAME = "name";

    public static final String COL_CONTACT = "contact";

    public static final String COL_CONTACT_PHONE = "contact_phone";

    public static final String COL_URL = "url";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";
}