import com.example.SakilaApplication;
import com.example.dao.ActorInfoMapper;
import com.example.domain.ActorInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class ActorInfoTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ActorInfoMapper actorInfoMapper;

    @Test
    public void test() {
        List<ActorInfo> actorInfos = actorInfoMapper.selectAll();
        for (ActorInfo actorInfo : actorInfos) {
            logger.info(" actor:{}", actorInfo.toString());
        }
    }
}
