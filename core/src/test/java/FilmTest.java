import com.example.MyApplication;
import com.example.dao.FilmListMapper;
import com.example.domain.FilmList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class FilmTest {

    @Autowired
    private FilmListMapper filmListMapper;

    @Test
    public void selectByCondition() {
        FilmList filmList = new FilmList();
        filmList.setTitle("STR");
        filmList.setRating("PG-13");
        List<FilmList> filmLists = filmListMapper.selectByCondition(filmList);
        for (FilmList film : filmLists) {
            System.out.println(film.toString());
        }
    }

}
