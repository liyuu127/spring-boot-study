package cn.liyu.clients;

import cn.liyu.bean.entity.Movies;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MiscellaneousElasticsearchOperationSupportTest {

    @Autowired
    ElasticsearchOperations elasticsearchTemplate;

    @Test
    public void test_scroll() {
        IndexCoordinates index = IndexCoordinates.of("movies");
//        Pageable pageable = Pageable.ofSize(5).withPage(0);
//        Query nativeSearchQuery = new NativeSearchQueryBuilder()
//                .withPageable(pageable)
//                .withQuery(matchAllQuery())
////                .withFields("title")
//                .build();

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withFields("title")
//                .withPageable(PageRequest.of(0, 10))
                .build();
//        SearchHits<Movies> search = elasticsearchTemplate.search(nativeSearchQuery, Movies.class, index);
//        for (SearchHit<Movies> moviesSearchHit : search) {
//            log.info(moviesSearchHit.getContent().toString());
//        }
        SearchHitsIterator<Movies> stream = elasticsearchTemplate.searchForStream(nativeSearchQuery, Movies.class, index);
        while (stream.hasNext()) {
            log.info(stream.next().getContent().toString());
        }

//        stream.close();
    }

    @Test
    public void test_runtime_filed(){
        IndexCoordinates index = IndexCoordinates.of("movies");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withFields("title")
//                .withPageable(PageRequest.of(0, 10))
                .build();
        String script = "emit(doc['title.keyword'+doc['year'])";
        RuntimeField runtimeField = new RuntimeField("titleYear", "text", script);
        nativeSearchQuery.addRuntimeField(runtimeField);
                SearchHits<Object> search = elasticsearchTemplate.search(nativeSearchQuery, Object.class, index);
        for (SearchHit<Object> moviesSearchHit : search) {
            log.info(moviesSearchHit.toString());
        }
    }
}
