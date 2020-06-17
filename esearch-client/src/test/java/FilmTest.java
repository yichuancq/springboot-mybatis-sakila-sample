import com.example.es.ESearchApplication;
import com.example.es.domain.FilmList;
import com.example.es.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Flux;

import java.util.*;

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


    /**
     * NativeSearchQuery 高亮查询
     */
    @Test
    public void queryHighLightSearchQuery() {
        List<FilmList> filmListList = new ArrayList<>();
        // 查询的关键字
        String queryWord = "Girl";
        // 查询的字段
        String field = "description";
        // page
        Integer page = 1;
        // pageSize
        Integer pageSize = 50;
        // 高亮设置
        String preTags = "<mark>";
        String postTags = "</mark>";
        IndexCoordinates index = IndexCoordinates.of(stringIndex);
        //创建builder
        NativeSearchQuery searchQuery =
                new NativeSearchQueryBuilder()
                        .withQuery(QueryBuilders.matchQuery(field, queryWord))
                        .withHighlightBuilder(new HighlightBuilder().field(field).preTags(preTags).postTags(postTags))
                        .withPageable(PageRequest.of(page, pageSize))
                        .build();
        Flux<SearchHit<FilmList>> searchHitFlux = elasticsearchOperations.search(searchQuery, FilmList.class, index);

        Iterator<SearchHit<FilmList>> filmListIterator = searchHitFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            SearchHit<FilmList> searchHit = filmListIterator.next();
            FilmList filmList = searchHit.getContent();
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            // 遍历打印
            // highlightFields.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + highlightFields.get(key)));
            // 替换字段
            highlightFields.keySet().forEach(key -> filmList.setDescription(String.valueOf(highlightFields.get(key).get(0))));
            filmListList.add(filmList);
        }
        for (FilmList filmList : filmListList) {
            log.info("filmList:{}", filmList);
        }
    }

    /**
     * 多字段匹配关键字
     */
    @Test
    public void testMatchPhrasePrefixQuery() {
        String queryText = "STA";
        // 高亮设置
        String preTags = "<mark>";
        String postTags = "</mark>";
        // page
        List<FilmList> filmListList = new ArrayList<>();
        IndexCoordinates index = IndexCoordinates.of(stringIndex);
        String descriptionField = "description";
        String titleField = "title";
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.should(QueryBuilders.matchPhrasePrefixQuery(descriptionField, queryText));
        boolQueryBuilder.should(QueryBuilders.matchPhrasePrefixQuery(titleField, queryText));
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withHighlightBuilder(new HighlightBuilder()
                        .field(titleField)
                        .field(descriptionField).preTags(preTags).postTags(postTags)).build();
        Flux<SearchHit<FilmList>> searchHitFlux = elasticsearchOperations.search(searchQuery, FilmList.class, index);
        Iterator<SearchHit<FilmList>> filmListIterator = searchHitFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            SearchHit<FilmList> searchHit = filmListIterator.next();
            FilmList filmList = searchHit.getContent();
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();

            for (Map.Entry<String, List<String>> entry : highlightFields.entrySet()) {
                String mapKey = entry.getKey();
                List<String> mapValue = entry.getValue();
                //title:<mark>NEWSIES</mark> STORY
                if (mapKey.equals(titleField)) {
                    filmList.setTitle(mapValue.get(0));
                } else if (mapKey.equals(descriptionField)) {
                    filmList.setDescription(mapValue.get(0));
                }
            }
            filmListList.add(filmList);
        }
        for (FilmList filmList : filmListList) {
            log.info("filmList:{}", filmList);
        }
    }
}
