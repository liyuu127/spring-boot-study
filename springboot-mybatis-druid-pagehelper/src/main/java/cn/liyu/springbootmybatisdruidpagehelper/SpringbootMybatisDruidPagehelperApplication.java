package cn.liyu.springbootmybatisdruidpagehelper;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//去掉自动注册了
@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
public class SpringbootMybatisDruidPagehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDruidPagehelperApplication.class, args);
    }

}
