package cn.liyu.bean.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "movies")
@Data
public
class Movies {
    @Id
    private String id;

    @Field(type = FieldType.Text, value = "@version")
    private String version;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private List<String> genre;

    @Field(type = FieldType.Long)
    private Long year;

//    @Transient
    private String titleYear;
}
