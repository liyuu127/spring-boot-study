package cn.liyu;

import cn.liyu.model.UserInfo;
import cn.liyu.utils.JwtUtils;
import cn.liyu.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author liyu
 * date 2020/8/5 18:09
 * description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    private static final String pubKeyPath = "rsa.pub";

    private static final String priKeyPath = "rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void test_creat_RSA() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "DRT");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
//        // 生成token
//        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
//        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU5NjYyMzgzMH0.mGZWSpB7pNHVRP0G6lqcG46DCr47wVQKoaTI7DF7kt288HN4UxLz1EGY7pccMGvR7svqfXCl8ht3M7Q0oMYm5aI3jhacQFi9WrLmufLh6ahIaOQgSh43j5PUXMORn9333ELVA9uMhT7dv5FYbMB6pefTMxhm4-sGH4aY1m5Y2uw";

        // 解析token
        UserInfo user = JwtUtils.getUserInfo(publicKey, token);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getName());
    }
}
