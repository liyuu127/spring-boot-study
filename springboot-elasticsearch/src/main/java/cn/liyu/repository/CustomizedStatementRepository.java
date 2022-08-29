package cn.liyu.repository;

import cn.liyu.bean.entity.Statement;

import java.util.List;

public interface CustomizedStatementRepository {
    List<Statement> findVoteByAnswerId(String answerId);

}
