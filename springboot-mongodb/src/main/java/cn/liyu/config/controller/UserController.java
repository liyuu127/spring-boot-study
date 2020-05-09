package cn.liyu.config.controller;

import cn.liyu.dao.IUserDao;
import cn.liyu.pojo.User;
import cn.liyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author liyu
 * @date 2020/5/8 16:05
 * @description
 */
@RestController
public class UserController {

    @Autowired
    IUserService iUserService;
    @Autowired
    IUserDao iUserDao;
    @Autowired
    MongoTemplate mongoTemplate;
    @GetMapping("/index/test/{id}")
    public User test(@PathVariable Integer id) {
        User user = new User();
        user.setAge(1);
        user.setId(id);
        user.setAddress("lalala");
        user.setUid(1);
        user.setDate(new Date());
        user.setName("zzm");
        iUserService.saveUser(user);
        return user;
    }

    @GetMapping("/index/findAll")
    @ResponseBody
    public List<User> findAll() {
        List<User> all = iUserDao.findAll();
        return all;
    }

    @GetMapping("/index/find")
    public  List<User> find() {
        List<User> zzm = iUserService.findUsersByName("zzm");
        return zzm;
    }

    @GetMapping("/index/delete/{id}")
    public String delete(@PathVariable Integer id) {
         iUserDao.deleteById(id);
        return "success";
    }

    /**
     * 复杂查询，分页，更新都可以使用MongoTemplate
     * @param id
     * @return
     */
    @GetMapping("/index/update/{id}")
    public List<User> update(@PathVariable String id) {
        Query query = new Query(Criteria.where("name").is(id).orOperator(Criteria.where("id").is(0)));
        mongoTemplate.updateFirst(query, new Update().set("name", "zxr"), User.class);
        List<User> zzm = iUserService.findUsersByName("zzm");
        return zzm;
    }
}
