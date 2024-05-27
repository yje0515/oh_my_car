package com.ohmycar.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml " })
@Log4j
@WebAppConfiguration
public class UserControllerTest {
    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void getMypage() throws Exception {
        ModelAndView mv = mvc
                .perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/user/mypage"))
                .andReturn().getModelAndView();
        if (mv != null) {
            log.info(mv.getModelMap());
        }
    }
}
