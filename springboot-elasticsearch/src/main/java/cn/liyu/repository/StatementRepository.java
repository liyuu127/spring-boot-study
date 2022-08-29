package cn.liyu.repository;

import cn.liyu.bean.entity.Statement;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StatementRepository extends ElasticsearchRepository<Statement, Integer>, CustomizedStatementRepository {


}
