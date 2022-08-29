package cn.liyu.config;

import org.springframework.data.mapping.callback.EntityCallback;

@FunctionalInterface
public interface BeforeSaveCallback<T> extends EntityCallback<T> {

    /**
     * Entity callback method invoked before a domain object is saved.
     * Can return either the same or a modified instance.
     *
     * @return the domain object to be persisted.
     */
    T onBeforeSave(T entity, String collection);
}
