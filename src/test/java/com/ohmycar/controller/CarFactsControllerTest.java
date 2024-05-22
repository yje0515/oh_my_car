package com.ohmycar.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.ohmycar.service.CarFactsService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
@WebAppConfiguration
public class CarFactsControllerTest {
    @Autowired
    private WebApplicationContext ctx;
    @Autowired
    private CarFactsService service;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
        ModelAndView mv = mvc.perform(MockMvcRequestBuilders.get("/carFacts/list")).andReturn().getModelAndView();
        if (mv != null) {
            log.info(mv.getModelMap());
        }
    }

    @Test
    public void testRead() throws Exception {
        ModelAndView mv = mvc.perform(MockMvcRequestBuilders.get("/carFacts/read")).andReturn().getModelAndView();
        if (mv != null) {
            log.info(mv.getModelMap());
        }
    }

    @Test
    public void testInsert() throws Exception {
        ModelAndView mv = mvc.perform(MockMvcRequestBuilders.post("/carFacts/create")
                .param("factText", "이것이 바로 조선의 테스트")).andReturn().getModelAndView();
        if (mv != null) {
            log.info(mv.getModelMap());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        ModelAndView mv = mvc.perform(MockMvcRequestBuilders.post("/carFacts/modify")
                .param("factId", "65")
                .param("factText", "이것이 바로 조선의 업데이트다.")).andReturn().getModelAndView();
        if (mv != null) {
            log.info(mv.getModelMap());
        }
        service.getAll();
    }

    @Test
    public void testDelete() throws Exception {
        ModelAndView mv = mvc.perform(MockMvcRequestBuilders.get("/carFacts/delete")
                .param("factId", "65")).andReturn().getModelAndView();
        if (mv != null) {
            log.info(mv.getModelMap());
        }
        service.getAll();
    }
}
