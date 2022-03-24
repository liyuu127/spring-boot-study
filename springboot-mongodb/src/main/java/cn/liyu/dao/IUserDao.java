package cn.liyu.dao;

import cn.liyu.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author liyu
 * @date 2020/5/8 15:50
 * @description
 */
public interface IUserDao extends MongoRepository<User, Integer> {
    List<User> findByName(String name);

    Stream<User> findAllByNameNull();
}
