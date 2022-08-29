/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.liyu.bean.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.Range;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;
import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Date;

/**
 * @author Artur Konczak
 * @author Oliver Gierke
 * @author Christoph Strobl
 * Mapping Annotation Overview refer to <a href="https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#reference"/a>
 */
@Data
@Builder
//indexName: the name of the index to store this entity in.
// This can contain a SpEL template expression like "log-#{T(java.time.LocalDate).now().toString()}"
@Document(indexName = "conference-index")
public class Conference {

//    @PersistenceConstructor
//    public Conference() {
//    }

    @Id
    private String id;
    private String name;

    //FieldNamingStrategy RestClientConfig
    @Field(name = "data", type = Date, format = {}, pattern = "dd.MM.uuuu")
    private java.util.Date date;

    private GeoPoint location;
    private List<String> keywords;

    @Transient
    private String excludesField;

//    @Field(type = FieldType.Integer_Range)
//    private ValidAge validAge;

    @Field(type = FieldType.Integer_Range)
    private Range<Integer> validAge;

//    @Getter
//    @Setter
//    class ValidAge {
//        @Field(name="gte")
//        private Integer from;
//
//        @Field(name="lte")
//        private Integer to;
//    }
}
