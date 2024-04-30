package com.ohmycar.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.ohmycar.domain.ConsumableVO;
import com.ohmycar.mapper.ConsumableMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ConsumableServiceImpl implements ConsumableService {

    private final ConsumableMapper consumableMapper;

    public ConsumableServiceImpl(ConsumableMapper consumableMapper) {
        this.consumableMapper = consumableMapper;
    }

    @Override
    public ConsumableVO read(String carId) {
        return consumableMapper.select(carId);
    }

    @Override
    public void create(ConsumableVO vo, String accessToken) {

        StringBuilder sb;
        String responseData = "";

        String token = "Bearer " + accessToken;
        String carID = vo.getCarId();
        String contentType = "application/json";
        try {
            String apiURL = "https://dev.kr-ccapi.hyundai.com/api/v1/car/status/" + carID + "/odometer";
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
                log.info("success");
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 에러발생
                log.info("error");
            }

            sb = new StringBuilder();
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData);
            }
            br.close();

            log.info(sb.toString());

        } catch (Exception e) {
            log.error(e);
        }

        // if (vo.getAirConFilter() == null) {
        // vo.setAirConFilter();
        // }
    }

    @Override
    public void modify(ConsumableVO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

    @Override
    public void delete(String carId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
