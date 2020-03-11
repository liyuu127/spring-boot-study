package cn.liyu.springbootrabbitmq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liyu
 * @date 2020/3/11 16:37
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 需要实现序列化接口
public class Programmer implements Serializable {

    private String name;

    private int age;

    private float salary;

    private Date birthday;

}