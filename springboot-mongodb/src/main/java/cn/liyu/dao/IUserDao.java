package cn.liyu.dao;

import cn.liyu.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author liyu
 * @date 2020/5/8 15:50
 * @description
 */
public interface IUserDao extends MongoRepository<User, Integer> {
    List<User> findByName(String name);
}
