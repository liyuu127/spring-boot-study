package cn.liyu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liyu
 * date 2020/8/5 18:13
 * description
 */
@Data
@AllArgsConstructor
public class UserInfo {

    private long id;
    /**
     * 用户类型 1:商家、2：车长
     */
    private int accountType;
    private String name;
}
