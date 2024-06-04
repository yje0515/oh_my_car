package com.ohmycar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ohmycar.domain.CarVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class CarMapperTests {

    @Autowired
    private CarMapper carMapper;

    @Test
    public void testGetCarByUserId() {
        String userId = "Tea";
        CarVO carVO = carMapper.getCarByCarId(userId);
        log.info(carVO);
    }
    //
    // @Test
    // public void testGetCarByCarId() {
    // String carId = "ESDAD123124";
    // CarVO carVO = carMapper.getCarByCarId(carId);
    // log.info(carVO);
    // }

}
