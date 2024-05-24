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
    public void testcreate() throws Exception {
        ConsumableVO vo = new ConsumableVO();
        vo.setCarId("ce7dfc88-f6b3-41ad-9099-4eb57bce4944");
        vo.setEngineOil("0");
        vo.setAirConFilter("0");
        vo.setWiper("2023-04-03");
        vo.setTire("0");
        vo.setCoolingWater("0");
        vo.setTransmissionOil("0");
        vo.setPowerSteeringOil("2023-04-03");
        vo.setSparkPlug("2023-04-03");
        vo.setFluidClutch("0");
        vo.setBattery("2023-04-03");
        // String accessToken =
        // "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI2NjRkYWZjZC05NmVhLTRhZjctOGI0MC1iYTYyNzgwNzI4ODciLCJpc3MiOiJibHVlbGluayIsInBpZCI6IjYyYTk3NmZhYmI4YjVkZTg5YzYzYjhmYiIsImV4cCI6NDEwMjMyNjAwMCwibGF0IjoxNzE0NTI1NzAzLCJzaWQiOiI0MDBiMzIzMS0zMGRiLTQyZjUtYWI1Mi05ZDY5YjM1YTE4NGQifQ.jQs641tZ9W9eidkTaGBygdRBvygWcojsFzxj92Z1493J8BAHgjMGpx1r6dWWMACBYLM7reROl59wDoaBlw8vqRKUU-Q1lmettmtBDKNsyjJya9Dwbht1vLMqds-eG6oFyY1SW5Ri6GQZ1F69UL0qJQpmiDksu1iSVEtVpzm3mLSzQpELuRJH1RsxWjBIWEgXopZIczQiLtjQDgY2Dkmq7VuT1hGPLAoQHeoihxxQo_bbLLEB1WQT1lY5nx6XwRfG7I6y0MF2gGOBNJrJNZy2BFXQvLm8ZWDVjrqNb4LVS1Vjh3DRXminBKDBDAz0Hyz7xfT4sFvouD2IdJmNQiUxrQ";
        // StringBuilder sb;
        // String responseData = "";

        // String token = "Bearer " + accessToken;
        // String carID = vo.getCarId();
        // String contentType = "application/json";
        // log.info(accessToken);
        // log.info(carID);
        // try {
        // String apiURL = "https://dev.kr-ccapi.hyundai.com/api/v1/car/status/" + carID
        // + "/odometer";
        // URL url = new URL(apiURL);

        // HttpURLConnection con = (HttpURLConnection) url.openConnection();
        // con.setRequestMethod("GET");

        // // Set Header Info
        // con.setRequestProperty("Authorization", token);
        // con.setRequestProperty("Content-Type", contentType);

        // int responseCode = con.getResponseCode();
        // BufferedReader br;
        // if (responseCode == HttpURLConnection.HTTP_OK) {
        // br = new BufferedReader(new InputStreamReader(con.getInputStream())); // 정상호출
        // log.info("success");
        // } else {
        // br = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 에러발생
        // log.info("error");
        // }

        // sb = new StringBuilder();
        // while ((responseData = br.readLine()) != null) {
        // sb.append(responseData);
        // }
        // br.close();

        // log.info(sb.toString());

        // } catch (Exception e) {
        // log.error(e);
        // }

        log.info(vo);
        service.create(vo, null);
    }

    @Test
    public void testModify() {
        ConsumableVO vo = new ConsumableVO();
        vo.setCarId("ce7dfc88-f6b3-41ad-9099-4eb57bce4944");
        vo.setEngineOil("0");
        vo.setAirConFilter("0");
        vo.setWiper("2023-04-03");
        vo.setTire("0");
        vo.setCoolingWater("0");
        vo.setTransmissionOil("0");
        vo.setPowerSteeringOil("2023-04-03");
        vo.setSparkPlug("2023-04-03");
        vo.setFluidClutch("0");
        vo.setBattery("2023-04-03");
        vo.setBreakOil("0");
        vo.setBreakPad("0");
        log.info(vo);
        service.modify(vo);
    }

    @Test
    public void testDelete() throws Exception {
        String carId = "ce7dfc88-f6b3-41ad-9099-4eb57bce4944";
        log.info(carId);
        service.delete(carId);
    }
}
