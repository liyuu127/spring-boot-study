package cn.liyu;

import cn.liyu.dao.IUserDao;
import cn.liyu.pojo.User;
import cn.liyu.service.IUserService;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author liyu
 * @date 2020/5/8 16:49
 * @description
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoTest {

    @Autowired
    IUserService iUserService;
    @Autowired
    IUserDao iUserDao;
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 测试继承的MongoDB仓库的通用方法
     */
    @Test
    public void testIUserDao(){
//        User user = new User();
//        user.setId(1002);
//        user.setUid(3);
//        user.setName("李宇");
//        user.setAge(19);
//        user.setDate(new Date());
//        user.setAddress("朝阳区");
//        System.out.println("user.toString() = " + user.toString());
//        User insert = iUserDao.insert(user);
//        System.out.println("insert.toString() = " + insert.toString());

        List<User> user = iUserDao.findByName("李宇");
        user.forEach(user1 -> System.out.println(user1.toString()));
    }

    /**
     * mongoTemplate使用
     */
    @Test
    public void testMongoTemplate(){
        Query query = new Query(Criteria.where("name").is("李宇"));
        UpdateResult updateResult = mongoTemplate.updateFirst(query, new Update().set("name", "liyu"), User.class);
        System.out.println("updateResult.toString() = " + updateResult.toString());
    }

}
