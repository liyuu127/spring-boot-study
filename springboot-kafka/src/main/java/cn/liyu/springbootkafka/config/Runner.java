package cn.liyu.springbootkafka.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author liyu
 * date 2021/4/9 16:22
 * description
 */
@Component
public class Runner  implements ApplicationRunner {
    @Value("${test.config}")
    public String key;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("key = " + key);
    }
}
