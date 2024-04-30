package com.ohmycar.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ohmycar.domain.ConsumableVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ConsumableServiceTest {
    @Autowired
    private ConsumableService service;

    @Test
    public void createTest() throws Exception {
        ConsumableVO vo = new ConsumableVO();
        vo.setCarId("b23f1cd3-517c-4ac0-b574-cfc8eeca5fed");
        vo.setEngineOil("0");
        vo.setAirConFilter("0");
        vo.setBreakOil("0");
        vo.setBreakPad("0");
        vo.setWiper("2023-04-03");
        vo.setTire("0");
        vo.setCoolingWater("0");
        vo.setTransmissionOil("0");
        vo.setPowerSteeringOil("2023-04-03");
        vo.setSparkPlug("2023-04-03");
        vo.setFluidClutch("0");
        vo.setBattery("2023-04-03");
        service.create(vo,
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI2NjRkYWZjZC05NmVhLTRhZjctOGI0MC1iYTYyNzgwNzI4ODciLCJpc3MiOiJibHVlbGluayIsInBpZCI6IjYyYTk3NmZhYmI4YjVkZTg5YzYzYjhmYiIsImV4cCI6NDEwMjMyNjAwMCwibGF0IjoxNzE0NDY2ODQ4LCJzaWQiOiI0MDBiMzIzMS0zMGRiLTQyZjUtYWI1Mi05ZDY5YjM1YTE4NGQifQ.PG1gOyniuSOBQ-HBovDHwpu6_8Mx3JpBXn2A01PXhZn4iRo9OPqTgcyUd32ZCgUdHE7A9y4E3V4q5MBNnjdj4s1a-kkThCWQJ5hwzthkHRbrMgjrYKMVBYE1mzoQbjmUwO2LSFa_hgpRHPIKXeZF1RiPoCGJFlDYcUhPQp5KSDUdLGXGAuPSygV2n8egFAz4ENwDi5d7aj0-ihH8F2Sdi2uusYmwmeA_TL9DFl9ibeVqGzYKNBErnWSYpRr7KPhC1uZbQqiM3YCTRHmkDT87-kPfNYsdSUnp4mKes6LW6ExFsnHTE0zoqePzi_VVkYGqxdwEE1aM-DQ7NQ7vugVSfQ");
    }// TODO Fix me crypto/rsa: verification error 이 에러 찾아라

}
