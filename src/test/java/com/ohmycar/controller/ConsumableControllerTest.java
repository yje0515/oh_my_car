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
        StringBuffer sb;
        String responseData = "";

        String token = "Bearer "
                + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI2NjRkYWZjZC05NmVhLTRhZjctOGI0MC1iYTYyNzgwNzI4ODciLCJpc3MiOiJibHVlbGluayIsInBpZCI6IjYyYTk3NmZhYmI4YjVkZTg5YzYzYjhmYiIsImV4cCI6NDEwMjMyNjAwMCwibGF0IjoxNzE1MDU5NzA2LCJzaWQiOiI0MDBiMzIzMS0zMGRiLTQyZjUtYWI1Mi05ZDY5YjM1YTE4NGQifQ.CXjiYH0jV53XBYQM33NQvRw27LZaWwKAor1hreOzlsffBzvgFXKWFC_Gz2fcdGnbunJnndxf5hnyLHnsaROsk9bBx800NuRYoR9vlZ92z8e1XrROLXwY8NhO9xIR_bbjK-i1AuxEpP-FqedwkxVvcqpRNfauvog1Bf4d4pjwGnKCybCoUj5GqfDvNbxcIT6G1Ri3tuhN7iAb0h-Zpab_e5vKSVH9eVEp5uNqH2za5qVmxx5jw13GHZNqAAPRKLqIcDv110Pn8xKs1SXYBnLVAdNCBAgWwjUnqn_O8W6ukCpHYQ3BJE2u7O7r8P93tES4sLdhramiWjnDWDxCzAxZJw";
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

            sb = new StringBuffer();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData);
            }
            br.close();

            // ConsumableOdometer odometer =
            // TODO API 에서 받아온 JSON 데이터 중 value 만 빼서 쓰는걸로 로직 구현 해라
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
