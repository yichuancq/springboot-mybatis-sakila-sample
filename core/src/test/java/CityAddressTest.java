import com.example.SakilaApplication;
import com.example.dao.CityMapper;
import com.example.domain.City;
import com.example.domain.Country;
import com.example.domain.address.Address;
import com.example.service.address.AddressService;
import com.example.service.city.CityService;
import com.example.service.country.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class CityAddressTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AddressService addressService;

    @Test
    public void saveCountry() {
        Country country = new Country();
        country.setCountry("中国");
        country.setCountryId(null);
        country.setLastUpdate(new Date());
        countryService.saveOne(country);
    }

    @Test
    public void saveCity() {
        Country country = countryService.findById(Short.valueOf("110"));
        City city = new City();
        city.setCityId(null);
        city.setCity("重庆");
        city.setLastUpdate(new Date());
        //
        city.setCountryId(country.getCountryId());
        cityService.saveOne(city);
    }

    @Test
    public void saveAddr() {
        City city = cityService.findOneById(Short.valueOf("601"));
        Address address = new Address();
        address.setAddressId(null);
        address.setAddress("重庆沙坪坝沙滨路xxx号");
        address.setAddress2("");
        address.setCityId(city.getCityId());
        address.setDistrict("");
        address.setPhone("123456");
        address.setDistrict("重庆沙坪坝");
        address.setLastUpdate(new Date());
        address.setPostalCode("400000");
        address.setLocation("POINT(106.55 18.25)");
        addressService.saveOne(address);
    }

    @Test
    public void findOneAddress() {

        Address address = addressService.findOneById(Short.valueOf("606"));
        logger.info("address :{}", address.toString());
    }

    @Test
    public void findOneById() {
        City city = cityMapper.selectByPrimaryKey((short) 1);
        System.out.println("" + city.toString());
    }
}
