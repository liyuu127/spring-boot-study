package cn.liyu.clients;

import cn.liyu.bean.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.elasticsearch.search.aggregations.AggregationBuilders.terms;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ElasticsearchOperationsTest {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Test
    public void index_delete_test() {

        boolean delete = elasticsearchOperations.indexOps(IndexCoordinates.of("spring-person")).delete();
        log.info("delete={}", delete);
    }

    @Test
    public void save_test() {
        Person person = Person.builder()
                .id(UUID.randomUUID().toString())
                .age(13)
                .firstname("pe")
                .lastname("ju").build();
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(person.getId())
                .withObject(person)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of("spring-person"));
        log.info("documentId={}", documentId);
    }

    @Test
    public void findById_test() {
        String id = "1dsa1";
        Person person = elasticsearchOperations.get(id, Person.class);
        log.info("person={}", person);

    }


    @Test
    public void queries_criteriaQuery_test() {
//	when talking about AND or OR when combining criteria keep in mind,
//	that in Elasticsearch AND are converted to a must condition and OR to a should
        Criteria age = new Criteria("age").is(12);
        CriteriaQuery criteriaQuery = new CriteriaQuery(age);
        SearchHits<Person> searchHits = elasticsearchOperations.search(criteriaQuery, Person.class);
        log.info("SearchHits={}", searchHits.getSearchHits());
    }

    @Test
    public void queries_stringQuery_test() {

        StringQuery stringQuery = new StringQuery("{\"match\": {\"lastname\": \"uyu\"}}");
        SearchHits<Person> searchHits = elasticsearchOperations.search(stringQuery, Person.class);
        log.info("SearchHits={}", searchHits.getSearchHits());
    }

    @Test
    public void queries_nativeSearchQuery_test() {
        Query query = new NativeSearchQueryBuilder()
                .withAggregations(terms("lastnames").field("lastname.keyword").size(10)) //
                .withQuery(QueryBuilders.matchQuery("firstname", "li"))
                .build();
        SearchHits<Person> searchHits = elasticsearchOperations.search(query, Person.class);
        log.info("SearchHits={}", searchHits.getSearchHits());
    }
}
