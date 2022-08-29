package cn.liyu.clients;

import cn.liyu.bean.entity.Statement;
import cn.liyu.repository.StatementRepository;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.join.query.HasChildQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.join.JoinField;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.join.query.JoinQueryBuilders.hasChildQuery;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class JoinTypeTest {

    @Autowired
    StatementRepository statementRepository;

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Test
    public void init_test() {
        statementRepository.deleteAll();

        Statement savedWeather = statementRepository.save(
                Statement.builder()
                        .withText("How is the weather?")
                        .withRelation(new JoinField<>("question"))
                        .build());

        Statement sunnyAnswer = statementRepository.save(
                Statement.builder()
                        .withText("sunny")
                        .withRelation(new JoinField<>("answer", savedWeather.getId()))
                        .build());

        statementRepository.save(
                Statement.builder()
                        .withText("rainy")
                        .withRelation(new JoinField<>("answer", savedWeather.getId()))
                        .build());

        statementRepository.save(
                Statement.builder()
                        .withText("I don't like the rain")
                        .withRelation(new JoinField<>("comment", savedWeather.getId()))
                        .build());

        statementRepository.save(
                Statement.builder()
                        .withText("+1 for the sun")
                        .withRouting(savedWeather.getId())
                        .withRelation(new JoinField<>("vote", sunnyAnswer.getId()))
                        .build());
        NativeSearchQuery vote = new NativeSearchQueryBuilder()
                .withQuery(hasChildQuery("vote", matchAllQuery(), ScoreMode.None))
                .build();
        SearchHits<Statement> search = elasticsearchOperations.search(vote, Statement.class);
        for (SearchHit<Statement> searchHit : search.getSearchHits()) {
            log.info(searchHit.getContent().toString());
        }
    }

    @Test
    public void test_customizedRepo(){
        List<Statement> voteByAnswerId = statementRepository.findVoteByAnswerId("EMpX6YIBsxBW-2-3PJ_J");
        for (Statement statement : voteByAnswerId) {
            log.info(statement.toString());
        }
    }
}
