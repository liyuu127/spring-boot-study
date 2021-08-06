package cn.liyu.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain =true)
@TableName(value = "merchant")
public class Merchant implements Serializable {
    /**
     * 商户表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户名称（全称）
     */
    @TableField(value = "name")
    private String name;

    /**
     * 商户社会统一信用代码
     */
    @TableField(value = "social_credit_code")
    private String socialCreditCode;

    /**
     * 联系电话
     */
    @TableField(value = "contact_phone")
    private String contactPhone;

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
     * 是否删除（0-否；1-是）
     */
    @TableField(value = "deleted")
    private Byte deleted;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    private static final long serialVersionUID = 1L;

    public static final String COL_NAME = "name";

    public static final String COL_SOCIAL_CREDIT_CODE = "social_credit_code";

    public static final String COL_CONTACT_PHONE = "contact_phone";

    public static final String COL_CREATED_AT = "created_at";

    public static final String COL_UPDATED_AT = "updated_at";

    public static final String COL_DELETED = "deleted";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";
}