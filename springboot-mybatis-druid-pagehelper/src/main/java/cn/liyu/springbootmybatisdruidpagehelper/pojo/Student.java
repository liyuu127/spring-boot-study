package cn.liyu.springbootmybatisdruidpagehelper.pojo;

import lombok.Data;

/**
 * @author liyu
 * @date 2019/12/27 9:24
 * @description
 */
@Data
public class Student {
    /** 学生编号*/
    private Long id;
    /** 学生姓名*/
    private String name;
    /** 学生年龄*/
    private Integer age;
}
