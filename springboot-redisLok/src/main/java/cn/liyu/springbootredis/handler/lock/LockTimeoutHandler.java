package cn.liyu.springbootredis.handler.lock;

import cn.liyu.springbootredis.lock.Lock;
import cn.liyu.springbootredis.model.LockInfo;
import org.aspectj.lang.JoinPoint;

/**
 * 获取锁超时的处理逻辑接口
 *
 * @author wanglaomo
 * @since 2019/4/15
 **/
public interface LockTimeoutHandler {

    void handle(LockInfo lockInfo, Lock lock, JoinPoint joinPoint);
}
