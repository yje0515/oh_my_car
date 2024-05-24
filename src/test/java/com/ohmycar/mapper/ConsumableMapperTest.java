package com.ohmycar.mapper;

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
public class ConsumableMapperTest {

    @Autowired
    private ConsumableMapper consumableMapper;

    @Test
    public void selectAllTest() throws Exception {
        log.info(consumableMapper.selectAll());
    }

    @Test
    public void selectTest() {
        String carId = "6d97337b-eb53-467b-baf4-7faec6d7065e";
        ConsumableVO vo = consumableMapper.select(carId);
        log.info(vo);
        log.info(vo.getCarId());
    }

    @Test
    public void timeTest() {
        log.info(consumableMapper.selectSysdate());
    }

    @Test
    public void insertTest() {
        ConsumableVO vo = new ConsumableVO();
        vo.setCarId("3f979d64-1e57-4ead-90af-25da1756e206");
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
        consumableMapper.insert(vo);
        log.info(consumableMapper.select(vo.getCarId()));
    }

    @Test
    public void updateTest() {
        ConsumableVO vo = new ConsumableVO();
        vo.setCarId("3f979d64-1e57-4ead-90af-25da1756e206");
        vo.setEngineOil("15");
        vo.setAirConFilter("15");
        vo.setBreakOil("15");
        vo.setBreakPad("15");
        vo.setWiper("2023-04-03");
        vo.setTire("15");
        vo.setCoolingWater("15");
        vo.setTransmissionOil("15");
        vo.setPowerSteeringOil("2023-04-03");
        vo.setSparkPlug("2023-04-03");
        vo.setFluidClutch("15");
        vo.setBattery("2023-04-03");
        consumableMapper.update(vo);
        log.info(consumableMapper.select(vo.getCarId()));
    }

    @Test
    public void deleteTest() {
        consumableMapper.delete("3f979d64-1e57-4ead-90af-25da1756e206");
        log.info(consumableMapper.selectAll());
    }
}
