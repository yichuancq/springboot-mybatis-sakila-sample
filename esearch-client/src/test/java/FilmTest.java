import com.example.es.ESearchApplication;
import com.example.es.domain.FilmList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
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


}
