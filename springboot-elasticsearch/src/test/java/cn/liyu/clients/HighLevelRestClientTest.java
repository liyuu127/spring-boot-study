package cn.liyu.clients;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.StringHelper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static java.util.Collections.singletonMap;
import static org.elasticsearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class HighLevelRestClientTest {
    @Autowired
    RestHighLevelClient highLevelClient;

    @Test
    public void High_Level_REST_Client_Test() throws IOException {
        String id = StringHelper.idToString(StringHelper.randomId());

        RestClient lowLevelClient = highLevelClient.getLowLevelClient();
        IndexRequest indexRequest = new IndexRequest("spring-data")
                .id(id)
                .source(singletonMap("feature", "high-level-rest-client"))
                .setRefreshPolicy(IMMEDIATE);
        IndexResponse indexResponse = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        log.info("indexRequest = " + indexRequest);
        log.info("indexResponse = " + indexResponse);

    }

    @Test
    public void High_Level_REST_Client_Test_2() throws IOException {

        var searchReq = new SearchRequest("spring-data");
        SearchResponse search = highLevelClient.search(searchReq, RequestOptions.DEFAULT);
        log.info("search={}", search);

    }
}
