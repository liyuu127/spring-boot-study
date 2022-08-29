package cn.liyu.config;

import cn.liyu.bean.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityCallbackConfiguration {
    @Bean
    BeforeSaveCallback<Person> unorderedLambdaReceiverCallback() {
        return (it, c) -> it;// ...
    }
}
