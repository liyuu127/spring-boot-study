package cn.liyu.bean.entity;

import lombok.Data;
import org.elasticsearch.core.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Document(indexName = "entities")
@Setting(
        shards = 2,
        replicas = 1,
        //	when defining sort fields, use the name of the Java property (firstField),
        //	not the name that might be defined for Elasticsearch (first_field)
        sortFields = {"secondField", "firstField"},
        //sortModes, sortOrders and sortMissingValues are optional,
        // but if they are set, the number of entries must match the number of sortFields elements
        sortModes = {Setting.SortMode.max, Setting.SortMode.min},
        sortOrders = {Setting.SortOrder.desc, Setting.SortOrder.asc},
        sortMissingValues = {Setting.SortMissing._last, Setting.SortMissing._first})
@Data
class Entity {
    @Nullable
    @Id
    private String id;

    @Nullable
    @Field(name = "first_field", type = FieldType.Keyword)
    private String firstField;

    @Nullable
    @Field(name = "second_field", type = FieldType.Keyword)
    private String secondField;

    // getter and setter...
}
