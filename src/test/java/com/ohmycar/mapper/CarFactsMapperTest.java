package com.ohmycar.mapper;

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
public class CarFactsMapperTest {
    @Autowired
    private CarFactsMapper mapper;

    @Test
    public void testSelectAll() throws Exception {
        log.info(mapper.selectAll());
    }

    @Test
    public void testSelect() throws Exception {
        log.info(mapper.selectOne(4));
    }

    @Test
    public void testInsert() throws Exception {
        CarFactsVO vo = new CarFactsVO();
        vo.setFactText("레이서 마리오 안드레티는 어떤 자동차 브랜드의 CEO이기도 했나요? 페라리(Ferrari)의 CEO였습니다.");
        mapper.insert(vo);
        log.info(mapper.selectAll());
    }

    @Test
    public void testUpdate() throws Exception {
        CarFactsVO vo = new CarFactsVO();
        vo.setFactId(1);
        vo.setFactText("레이서 마리오 안드레티는 어떤 자동차 브랜드의 CEO이기도 했나요? 페라리(Ferrari)의 CEO였습니다.");
        mapper.update(vo);
        log.info(mapper.selectAll());
    }

    @Test
    public void testDelete() throws Exception {
        mapper.delete(1);
        log.info(mapper.selectAll());
    }
}
