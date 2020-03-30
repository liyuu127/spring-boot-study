package cn.liyu.springbootredis;

import cn.liyu.springbootredis.annotation.Klock;
import cn.liyu.springbootredis.annotation.KlockKey;
import cn.liyu.springbootredis.model.LockTimeoutStrategy;
import org.springframework.stereotype.Service;

/**
 * Created by kl on 2017/12/29.
 */
@Service
public class TestService {

    @Klock(waitTime = 10,leaseTime = 60,keys = {"#param"},lockTimeoutStrategy = LockTimeoutStrategy.FAIL_FAST)
    public String getValue(String param) throws Exception {
      //  if ("sleep".equals(param)) {//线程休眠或者断点阻塞，达到一直占用锁的测试效果
            Thread.sleep(1000*3);
        //}
        return "success";
    }

    @Klock(keys = {"#userId"})
    public String getValue(String userId,@KlockKey Integer id)throws Exception{
        Thread.sleep(60*1000);
        return "success";
    }

    @Klock(keys = {"#user.name","#user.id"})
    public String getValue(User user)throws Exception{
        Thread.sleep(60*1000);
        return "success";
    }

}
