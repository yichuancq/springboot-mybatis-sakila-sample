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
    public void test() throws IOException {

    }
}
