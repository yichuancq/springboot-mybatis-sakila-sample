import com.example.es.ESearchApplication;
import com.example.es.domain.FilmList;
import com.example.es.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ESearchApplication.class)
@Slf4j
public class FilmTest {
    //index
    private final String stringIndex = "nicer_but_slower_film_list";

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ReactiveElasticsearchOperations elasticsearchOperations;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations2;
    @Autowired
    private FilmService filmService;


    /**
     * 通过ID查询数据
     */
    @Test
    public void findOneById() {
        FilmList filmList = elasticsearchRestTemplate.get("pgosvHIBehbceu-UnoTz", FilmList.class);
        log.info("data:{}", filmList.toString());
    }

    /**
     * 通过IDs和索引查询数据
     */
    @Test
    public void findMoreById() {
        Collection<String> ids = new ArrayList<>();
        //数据item的Id
        ids.add("pgosvHIBehbceu-UnoTz");
        ids.add("EAosvHIBehbceu-Unof3");
        //索引
        IndexCoordinates indexCoordinates = IndexCoordinates.of(stringIndex);
        Query query = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withIds(ids)
                .withFields("description")
                .withPageable(PageRequest.of(0, 10))
                .build();
        List<FilmList> resultList = elasticsearchRestTemplate.multiGet(query, FilmList.class, indexCoordinates);
        for (FilmList filmList : resultList) {
            log.info("data:{}", filmList.toString());
        }
    }

    /**
     *
     */
    @Test
    public void findHasOne() {
        Boolean hasFlag = elasticsearchRestTemplate.exists("pgosvHIBehbceu-UnoTz", FilmList.class);
        log.info("hasFlag:{}", hasFlag);
    }

    /**
     *
     */
    @Test
    public void textSearch() {
        String queryWord = "Girl";
        CriteriaQuery query = new CriteriaQuery(new Criteria("description").contains(queryWord));
        Flux<SearchHit<FilmList>> searchHitFlux = elasticsearchOperations.search(query, FilmList.class);
        Iterator<SearchHit<FilmList>> filmListIterator = searchHitFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            SearchHit<FilmList> searchHit = filmListIterator.next();
            FilmList filmList = searchHit.getContent();
            log.info("filmList:{}", filmList);
        }
    }

    /**
     * 查询description字段包含关键字的数据
     */
    @Test
    public void testQueryFilmListFlux() {
        String queryWord = "Girl";
        Flux<FilmList> filmListFlux = filmService.findAllByDescriptionLike(queryWord);
        Iterator<FilmList> filmListIterator = filmListFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            FilmList filmList = filmListIterator.next();
            System.out.println(filmList.toString());
        }
    }


    /**
     * nativeSearchQuery
     */
    @Test
    public void queryNativeSearchQuery() {
        //创建builder
        String queryWord = "Girl";
        IndexCoordinates index = IndexCoordinates.of(stringIndex);
        NativeSearchQuery searchQuery =
                new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("description",
                        queryWord)).build();
        Flux<SearchHit<FilmList>> searchHitFlux = elasticsearchOperations.search(searchQuery, FilmList.class, index);
        Iterator<SearchHit<FilmList>> filmListIterator = searchHitFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            SearchHit<FilmList> searchHit = filmListIterator.next();
            FilmList filmList = searchHit.getContent();
            log.info("filmList:{}", filmList);
        }
    }

}
