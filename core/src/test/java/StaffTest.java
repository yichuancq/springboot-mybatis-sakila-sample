import com.example.MyApplication;
import com.example.domain.Staff;
import com.example.service.staff.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class StaffTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StaffService staffService;

    @Test
    public void saveOne() {
        Staff staff = new Staff();
        staff.setStaffId(null);
        staff.setFirstName("yi");
        staff.setLastName("chuan");
        staff.setActive(true);
        staff.setAddressId((short) 1);
        staff.setStoreId(Byte.valueOf("1"));
        staff.setEmail("yichuancq@163.com");
        staff.setUsername("yichuan");
        staff.setLastUpdate(new Date());
        Integer count = staffService.saveOne(staff);
        logger.info("save count:{}", count);
    }
}
