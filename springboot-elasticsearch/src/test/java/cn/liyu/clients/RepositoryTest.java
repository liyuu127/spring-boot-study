package cn.liyu.clients;

import cn.liyu.bean.entity.Movies;
import cn.liyu.repository.MoviesRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RepositoryTest {
    @Autowired
    MoviesRepository moviesRepository;

    @Test
    public void query_highlight_test() {
        List<SearchHit<Movies>> byVersionAndYear = moviesRepository.findByVersionAndYear("1", 1998L);
        for (SearchHit<Movies> movies : byVersionAndYear) {
            log.info(movies.toString());
        }
    }

    public void query_page_test() {
        Pageable pageable=Pageable.ofSize(5).withPage(1);
        Page<Movies> movies = moviesRepository.findByVersion("1", pageable);
        for (Movies movie : movies) {
            log.info(movie.toString());
        }
    }

}
