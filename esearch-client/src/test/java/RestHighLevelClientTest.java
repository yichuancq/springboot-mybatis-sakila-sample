import com.example.es.ESearchApplication;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ESearchApplication.class)
@Slf4j
public class RestHighLevelClientTest {
    private final String stringIndex = "nicer_but_slower_film_list";

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Test
    public void test1() throws IOException {
//        Class<?> leaveClass = highLevelClient.getClass();
//        log.info(leaveClass.getName());
//        //IndexCoordinates index = IndexCoordinates.of(stringIndex);
//        RequestOptions requestOptions=null;
//                SearchRequest searchRequest = new SearchRequest();
//        //创建一个Builder 对象 对条件进行封
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        //查询条件: 字段名为description  内容含有Tom的数据
//        searchSourceBuilder.query(QueryBuilders.prefixQuery("description", "Tom"));
//        //searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(10);
//        // 进行构建
//        searchRequest.source(searchSourceBuilder);
//        searchRequest.scroll(TimeValue.timeValueMinutes(1L));
//
//        MoreLikeThisQuery query = new MoreLikeThisQuery();
//        query.addFields("description");
//        query.addSearchIndices(stringIndex);
//        highLevelClient.search(searchRequest,requestOptions);
    }
}
