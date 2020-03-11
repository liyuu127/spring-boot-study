package cn.liyu.springbootmybatisdruidpagehelper.service.impl;

import cn.liyu.springbootmybatisdruidpagehelper.dao.BaseDao;
import cn.liyu.springbootmybatisdruidpagehelper.dao.master.UserDao;
import cn.liyu.springbootmybatisdruidpagehelper.pojo.User;
import cn.liyu.springbootmybatisdruidpagehelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyu
 * @date 2019/12/27 13:57
 * @description
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao<User> getMapper() {
        return this.userDao;
    }

}
