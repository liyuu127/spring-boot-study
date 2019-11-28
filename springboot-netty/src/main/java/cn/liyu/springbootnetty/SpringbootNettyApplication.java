package cn.liyu.springbootnetty;

import cn.liyu.springbootnetty.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootNettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNettyApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(0, 0);
    }
}
