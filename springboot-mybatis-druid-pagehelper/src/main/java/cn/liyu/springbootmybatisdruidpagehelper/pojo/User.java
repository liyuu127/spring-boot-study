package cn.liyu.springbootmybatisdruidpagehelper.pojo;

import lombok.Data;

/**
 * @author liyu
 * @date 2019/12/27 9:21
 * @description
 */
@Data
public class User {
    /** 编号*/
    private Long id;
    /** 姓名*/
    private String name;
    /** 年龄*/
    private Integer age;
}
