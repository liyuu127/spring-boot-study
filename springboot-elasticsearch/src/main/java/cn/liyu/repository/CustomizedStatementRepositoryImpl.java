package cn.liyu.repository;

import cn.liyu.bean.entity.Statement;
import org.apache.lucene.search.join.ScoreMode;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.join.query.JoinQueryBuilders.*;

@Repository
public class CustomizedStatementRepositoryImpl implements CustomizedStatementRepository {
    private final ElasticsearchOperations elasticsearchOperations;

    public CustomizedStatementRepositoryImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public List<Statement> findVoteByAnswerId(String answerId) {
        NativeSearchQuery vote = new NativeSearchQueryBuilder()
//                .withQuery(hasParentQuery("answer",matchQuery("_id",answerId),false))
                .withQuery(parentId("vote", answerId))
                .build();
        SearchHits<Statement> search = elasticsearchOperations.search(vote, Statement.class);
        return search.stream().map(SearchHit::getContent).collect(Collectors.toList());
    }
}
