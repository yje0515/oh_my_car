package com.ohmycar.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ohmycar.domain.CarFactsVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CarFactsServiceTest {
    @Autowired
    private CarFactsService service;

    @Test
    public void testSelectAll() throws Exception {
        log.info(service.getAll());
    }

    @Test
    public void testSelect() throws Exception {
        log.info(service.read());
    }

    @Test
    public void testInsert() throws Exception {
        CarFactsVO vo = new CarFactsVO();
        vo.setFactText("테스트다 이자식아");
        service.create(vo);
        log.info(service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        CarFactsVO vo = new CarFactsVO();
        vo.setFactId(64);
        vo.setFactText("테스트 업데이트다 이자식아");
        service.modify(vo);
        log.info(service.getAll());
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(64);
        log.info(service.getAll());
    }
}
