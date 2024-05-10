package com.ohmycar.domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 부품 교체 시기 에 관한 계산을 하는 클래스
 */
public class ConsumableCalc {

    public ConsumableCalc() {
        super();
    }

    /**
     * json 데이터를 읽어 교체시기를 계산 하는 함수
     * 
     * @param before 교체한 시기 혹은 거리
     * @param cycle  교체 주기
     * @param op     교체 주기가 날짜 형식인지 거리 형식인지 알기 위해 적어두는 operator
     * @return 교체 시기 혹은 거리가 담긴 String
     */
    private String calcChangeDay(String before, String cycle, char op) {
        if (op == 'y') {
            int next = (int) (Double.parseDouble(cycle) * 12);
            LocalDate date = LocalDate.parse(before, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            date = date.plusMonths(next);
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else if (op == 'k') {
            double beforeNum = Double.parseDouble(before);
            double cycleNum = Double.parseDouble(cycle);
            double next = beforeNum + cycleNum;
            return String.valueOf(next);
        } else {
            return "unknown";
        }
    }

    /**
     * consumableVO 에 담긴 교체한 시기 혹은 거리에 json 데이터를 읽어와
     * calcChangeDay 함수로 교체 시기 혹은 거리 를 담아 반환 하는 함수
     * 
     * @param next 교체한 시기가 담긴 consumbaleVO
     * @return 교체 시기가 담긴 consumbaleVO
     * @throws IOException json 데이터를 읽어올 때 발생하는 예외 json 데이터의 형식이 다르면 뜬다.
     */
    public ConsumableVO getNextConsumableVO(ConsumableVO next) throws IOException {
        InputStream input = new FileInputStream(
                "c:/SpringWorkSpace/oh_my_car/src/main/webapp/resources/json/consumableCycle.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ConsumableCycle consumableCycle = objectMapper.readValue(input, ConsumableCycle.class);

        String st = consumableCycle.getAirConFilter();
        next.setAirConFilter(
                calcChangeDay(next.getAirConFilter(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBattery();
        next.setBattery(
                calcChangeDay(next.getBattery(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakOil();
        next.setBreakOil(
                calcChangeDay(next.getBreakOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getBreakPad();
        next.setBreakPad(
                calcChangeDay(next.getBreakPad(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getCoolingWater();
        next.setCoolingWater(
                calcChangeDay(next.getCoolingWater(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getEngineOil();
        next.setEngineOil(
                calcChangeDay(next.getEngineOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getFluidClutch();
        next.setFluidClutch(
                calcChangeDay(next.getFluidClutch(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getPowerSteeringOil();
        next.setPowerSteeringOil(
                calcChangeDay(next.getPowerSteeringOil(), st.substring(0, st.length() - 1),
                        st.charAt(st.length() - 1)));
        st = consumableCycle.getSparkPlug();
        next.setSparkPlug(
                calcChangeDay(next.getSparkPlug(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTire();
        next.setTire(
                calcChangeDay(next.getTire(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getTransmissionOil();
        next.setTransmissionOil(
                calcChangeDay(next.getTransmissionOil(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        st = consumableCycle.getWiper();
        next.setWiper(
                calcChangeDay(next.getWiper(), st.substring(0, st.length() - 1), st.charAt(st.length() - 1)));
        return next;

    }

    /**
     * 현재 주행거리를 반환 하는 함수
     * TODO : token 과 carID 는 파라미터로 받아야 한다. 나중에 로그인 과 마이페이지가 완성 되면 연동한다.
     * 
     * @return 현재 누적 주행 거리
     */
    public String getAccDist() {
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
        ConsumableOdometer conOdo = new ConsumableOdometer();
        try {
            conOdo = mapper.readValue(sb.toString(), ConsumableOdometer.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        double accDist = conOdo.getOdometers().get(0).getValue();

        return Double.toString(accDist);
    }
}
