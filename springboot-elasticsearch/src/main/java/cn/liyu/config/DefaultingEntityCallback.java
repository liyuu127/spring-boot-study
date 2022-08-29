package cn.liyu.config;

import cn.liyu.bean.entity.Person;
import org.springframework.core.Ordered;

public class DefaultingEntityCallback implements BeforeSaveCallback<Person>, Ordered {
    @Override
    public int getOrder() {
        return 100;
    }

    @Override
    public Person onBeforeSave(Person entity, String collection) {
        return null;
    }
}
