package cn.liyu.service;

import cn.liyu.pojo.User;

import java.util.List;

/**
 * @author liyu
 * @date 2020/5/8 15:53
 * @description
 */
public interface IUserService {
    void saveUser(User user);

    List<User> findUsersByName(String name);
}
