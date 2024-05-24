package com.ohmycar.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohmycar.domain.ConsumableOdometer;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
@WebAppConfiguration
public class ConsumableControllerTest {
    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void readTest() throws Exception {
        ModelAndView mv = mvc.perform(MockMvcRequestBuilders.get("/consumable/read")
                .param("carId", "6d97337b-eb53-467b-baf4-7faec6d7065e")).andReturn().getModelAndView();
        if (mv != null) {
            log.info(mv.getModelMap());
        }
    }

    @Test
    public void testInsert() throws Exception {
        StringBuilder sb = new StringBuilder();
        String responseData = "";

        String token = "Bearer "
                + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI2NjRkYWZjZC05NmVhLTRhZjctOGI0MC1iYTYyNzgwNzI4ODciLCJpc3MiOiJibHVlbGluayIsInBpZCI6IjYyYTk3NmZhYmI4YjVkZTg5YzYzYjhmYiIsImV4cCI6NDEwMjMyNjAwMCwibGF0IjoxNzE1MTI4NDkzLCJzaWQiOiI0MDBiMzIzMS0zMGRiLTQyZjUtYWI1Mi05ZDY5YjM1YTE4NGQifQ.pZuBsie3in_l-TqVBtFPlXWgvQHbbF62yVPRfZvaJ0CCthBAlgp0Au4yxIt9ETE1S5O86EVi2y7VnkWstig-zo3pNW4BT22snQ-GshmSJ_NfOf_s5ollcqjNdqKNVmF588xP9pdWKnBB3hb_YLZLFGhUDjGaOI684mq4CCZ7V_vggTlaaXZZ6ycNvk58WhT5cpKccfHa6KkTFJhFwOJiKaG-z6snhPO33RIuNxwtrC7AikVu4B71guIJmBHcZ31HPjqVcAZwU2AR3eLNCk7XHdFFZR2gQUpGvaw81ECd1F48LSnvAY60MrsyH-nnO_sxNI8sakqGuMoSv8_Le_J5Qw";
        String carID = "6d97337b-eb53-467b-baf4-7faec6d7065e";
        String contentType = "application/json";
        try {
            String apiURL = "https://dev.kr-ccapi.hyundai.com/api_sample/v1/car/status/" + carID + "/odometer";
            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Set Header Info
            con.setRequestProperty("Authorization", token);
            con.setRequestProperty("Content-Type", contentType);

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream())); // 정상호출
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 에러발생
            }

            sb = new StringBuilder();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        ConsumableOdometer conOdo = mapper.readValue(sb.toString(), ConsumableOdometer.class);
        double accDist = conOdo.getOdometers().get(0).getValue();
        log.info("......................................................................" + accDist);
    }
}
