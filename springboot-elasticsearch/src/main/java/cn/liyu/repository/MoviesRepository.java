package cn.liyu.repository;

import cn.liyu.bean.entity.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviesRepository extends Repository<Movies, String> {


    @Highlight(fields = {
            @HighlightField(name = "version"),
            @HighlightField(name = "title")
    })
    List<SearchHit<Movies>> findByVersionAndYear(@Param("version") String version, @Param("year") Long year);

    @Query("{\"match\": {\"@version\": {\"query\": \"?0\"}}}")
    Page<Movies> findByVersion(String version, Pageable pageable);
}
