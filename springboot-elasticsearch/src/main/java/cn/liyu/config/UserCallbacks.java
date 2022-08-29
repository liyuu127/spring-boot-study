package cn.liyu.config;

import cn.liyu.bean.entity.User;
import org.springframework.data.elasticsearch.core.event.BeforeConvertCallback;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Component;

@Component
public class UserCallbacks implements BeforeConvertCallback<User>, BeforeSaveCallback<User> {


    @Override
    public User onBeforeSave(User entity, String collection) {
        return null;
    }

    @Override
    public User onBeforeConvert(User entity, IndexCoordinates index) {
        return null;
    }
}
