package cn.liyu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author liyu
 * @date 2020/5/8 15:44
 * @description
 */
@Document
@Data
public class User {
    @Id
    private Integer id;  //自定义id
    @Indexed
    private Integer uid; //使用索引
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    @Transient
    private String address;
}
