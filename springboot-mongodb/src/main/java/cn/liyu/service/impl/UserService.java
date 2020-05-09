package cn.liyu.service.impl;

import cn.liyu.dao.IUserDao;
import cn.liyu.pojo.User;
import cn.liyu.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyu
 * @date 2020/5/8 15:54
 * @description
 */
@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public void saveUser(User user) {
        User user1 = userDao.save(user);
        log.info("User={}", user1.toString());
    }

    @Override
    public List<User> findUsersByName(String name) {
        return userDao.findByName(name);
    }
}
