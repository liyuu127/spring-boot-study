package cn.liyu.bean.entity;

import cn.liyu.bean.entity.AuditMetadata;
import cn.liyu.bean.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(indexName = "spring-person")
public class Person implements Persistable<String> {
    @Id
    private String id;
    private Integer age;
    private String firstname, lastname;
    @CreatedBy
    private User createdBy;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @LastModifiedBy
    private User lastModifiedBy;

    public String getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return this.id == null || (createdDate == null || createdBy == null);
    }
}
